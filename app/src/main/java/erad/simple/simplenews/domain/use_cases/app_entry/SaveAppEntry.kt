package erad.simple.simplenews.domain.use_cases.app_entry

import erad.simple.simplenews.domain.manager.LocalUserManager

class SaveAppEntry(
    private val localUserManager: LocalUserManager
) {
    suspend operator fun invoke() {
        localUserManager.saveAppEntry()
    }
}