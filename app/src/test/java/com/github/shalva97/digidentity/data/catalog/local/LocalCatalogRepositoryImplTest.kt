@file:OptIn(ExperimentalCoroutinesApi::class)

package com.github.shalva97.digidentity.data.catalog.local

import com.github.shalva97.digidentity.domain.LocalCatalogRepository
import com.github.shalva97.digidentity.domain.models.Catalog
import com.github.shalva97.digidentity.fakes.FakeCatalogDaoImpl
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Test
import kotlin.test.assertEquals

class LocalCatalogRepositoryImplTest {
    @Test
    fun `Entities from Room are correctly returned`() = runTest {
        val repo: LocalCatalogRepository =
            LocalCatalogRepositoryImpl(UnconfinedTestDispatcher(), FakeCatalogDaoImpl())

        assertEquals(expected = sampleCatalog, actual = repo.findItemBy(sampleCatalog.id))
    }
}

private val sampleCatalog = Catalog(
    text = "Elegant piece of furniture that enhances the beauty of your living space.",
    confidence = 0.93f,
    image = "https://example.com/images/elegant-furniture.jpg",
    id = "656789-ZABCD"
)
