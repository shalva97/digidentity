package com.github.shalva97.digidentity

import com.github.shalva97.digidentity.domain.CatalogRepository
import com.github.shalva97.digidentity.fakes.FakeCatalogRepository
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import javax.inject.Inject


@HiltAndroidTest
class LearningTest {

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @Inject
    lateinit var repo: CatalogRepository

    @Before
    fun init() {
        hiltRule.inject()
    }

    @Test
    fun experimentingWithAPI() = runBlocking {
        val firstPage = repo.getItems()
        println(firstPage)
        println("second Page: ${repo.getItems(firstPage.last().id)}")
    }

    @Test
    fun blah() = runTest {
        val fakeRepo = FakeCatalogRepository()

        fakeRepo.getItems()
    }

}
