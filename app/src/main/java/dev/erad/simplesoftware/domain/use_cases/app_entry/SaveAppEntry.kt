package dev.erad.simplesoftware.domain.use_cases.app_entry

import dev.erad.simplesoftware.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}