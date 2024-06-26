package com.github.shalva97.digidentity.navigation

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.isDisplayed
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onNodeWithTag
import androidx.compose.ui.test.onNodeWithText
import androidx.compose.ui.test.performClick
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import com.github.shalva97.digidentity.data.catalog.local.CatalogDatabase
import com.github.shalva97.digidentity.data.catalog.local.di.DatabaseModule
import com.github.shalva97.digidentity.data.catalog.remote.di.CatalogRepoBinds
import com.github.shalva97.digidentity.domain.CatalogRepository
import com.github.shalva97.digidentity.fakes.FakeCatalogRepository
import com.github.shalva97.digidentity.fakes.sampleCatalogs
import com.github.shalva97.digidentity.presentation.MainActivity
import dagger.hilt.android.testing.BindValue
import dagger.hilt.android.testing.HiltAndroidRule
import dagger.hilt.android.testing.HiltAndroidTest
import dagger.hilt.android.testing.UninstallModules
import org.junit.Before
import org.junit.Rule
import kotlin.test.Test

@UninstallModules(CatalogRepoBinds::class, DatabaseModule::class)
@HiltAndroidTest
class NavigationTest {

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

    @get:Rule
    var hiltRule = HiltAndroidRule(this)

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @Before
    fun setUp() {
        hiltRule.inject()
    }

    @Test
    fun when_app_open_then_home_screen_is_shown() {
        composeTestRule.onNodeWithTag("HomeScreen").assertIsDisplayed()
    }

    @Test
    fun when_clicking_on_item_then_details_screen_opens() {
        val text = sampleCatalogs.first().text
        composeTestRule.onNodeWithText(text).performClick()
        composeTestRule.onNodeWithText("Text: $text", useUnmergedTree = true).isDisplayed()
    }
}
