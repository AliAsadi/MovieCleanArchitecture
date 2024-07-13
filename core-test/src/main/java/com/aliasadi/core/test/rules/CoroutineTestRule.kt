package com.aliasadi.core.test.rules

import com.aliasadi.core.provider.DispatchersProvider
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.MainCoroutineDispatcher
import kotlinx.coroutines.test.*
import org.junit.rules.TestWatcher
import org.junit.runner.Description

/**
 * Created by Ali Asadi on 16/05/2020
 **/
@OptIn(ExperimentalCoroutinesApi::class)
class CoroutineTestRule : TestWatcher() {

    internal val testDispatcher: TestDispatcher = UnconfinedTestDispatcher()

    override fun starting(description: Description) {
        super.starting(description)
        Dispatchers.setMain(testDispatcher)
    }

    override fun finished(description: Description) {
        super.finished(description)
        Dispatchers.resetMain()
    }

    val testDispatcherProvider = object : DispatchersProvider {
        override val main: MainCoroutineDispatcher = Dispatchers.Main
        override val io: CoroutineDispatcher = testDispatcher
        override val default: CoroutineDispatcher = testDispatcher
    }
}
