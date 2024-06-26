@file:OptIn(ExperimentalCoroutinesApi::class)

package com.github.shalva97.digidentity.data.catalog.remote

import com.github.shalva97.digidentity.domain.models.Catalog
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Before
import kotlin.test.Test
import kotlin.test.assertContains

class CatalogRepositoryImplTest {

    private val catalogRemoteDataSource: CatalogRemoteDataSource = FakeCatalogRemoteDataSourceImpl()

    private lateinit var catalogRepository: CatalogRepositoryImpl

    @Before
    fun before() {
        catalogRepository =
            CatalogRepositoryImpl(catalogRemoteDataSource, UnconfinedTestDispatcher())
    }

    @Test
    fun `getItems should return list of Catalogs`() = runTest {
        val expectedCatalog = catalog

        val result = catalogRepository.getItems()

        assertContains(result, expectedCatalog)
    }
}

private val catalog = Catalog(
    text = "Sample Text",
    confidence = 0.95f,
    image = "https://example.com/image.jpg",
    id = "12345"
)
