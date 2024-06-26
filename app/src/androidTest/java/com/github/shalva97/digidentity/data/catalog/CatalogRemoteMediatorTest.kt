package com.github.shalva97.digidentity.data.catalog

import androidx.paging.PagingData
import androidx.paging.testing.asSnapshot
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.github.shalva97.digidentity.data.catalog.local.CatalogDatabase
import com.github.shalva97.digidentity.data.catalog.local.di.DatabaseModule
import com.github.shalva97.digidentity.data.catalog.remote.di.CatalogRepoBinds
import com.github.shalva97.digidentity.domain.CatalogRepository
import com.github.shalva97.digidentity.domain.models.Catalog
import com.github.shalva97.digidentity.fakes.FakeCatalogRepository
import com.github.shalva97.digidentity.fakes.sampleCatalogs
import com.github.shalva97.digidentity.presentation.screens.home.HomeViewModel
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject
import kotlin.test.assertNotNull

@UninstallModules(CatalogRepoBinds::class, DatabaseModule::class)
@HiltAndroidTest
class CatalogRemoteMediatorTest {


    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @BindValue
    @JvmField
    val catalogRepository: CatalogRepository = FakeCatalogRepository()

    @BindValue
    @JvmField
    val mockDb: CatalogDatabase = Room.inMemoryDatabaseBuilder(
        ApplicationProvider.getApplicationContext(),
        CatalogDatabase::class.java
    ).build()

    @BindValue
    @JvmField
    val mockDao = mockDb.dao

    @Inject
    lateinit var pagingData: Flow<PagingData<Catalog>>
    private lateinit var homeViewModel: HomeViewModel

    @Before
    fun setUp() {
        hiltRule.inject()
        homeViewModel = HomeViewModel(pagingData)
    }

    @After
    fun tearDown() {
        mockDb.clearAllTables()
    }

    @Test
    fun when_scrolled_to_index_7_then_items_contain_expected_catalogs() = runTest {

        val items: Flow<PagingData<Catalog>> = homeViewModel.catalogs

        val itemsSnapshot: List<Catalog> = items.asSnapshot {
            scrollTo(index = 7)
        }

        val expectedItems = sampleCatalogs.take(10)
        assert(
            itemsSnapshot.containsAll(expectedItems)
        )
    }

    @Test
    fun when_scrolled_to_index_15_then_this_item_is_shown() = runTest {

        val items: Flow<PagingData<Catalog>> = homeViewModel.catalogs

        val itemsSnapshot: List<Catalog> = items.asSnapshot {
            scrollTo(index = 15)
        }

        val expectedItems = sampleCatalogs[15]

        assert(itemsSnapshot.contains(expectedItems))
    }

    @Test
    fun when_first_page_loads_then_items_are_saved_to_Room() = runTest {
        val items: Flow<PagingData<Catalog>> = homeViewModel.catalogs

        items.asSnapshot {
            scrollTo(index = 7)
        }

        assertNotNull(mockDb.dao.getCatalogById(sampleCatalogs.first().id))
    }
}
