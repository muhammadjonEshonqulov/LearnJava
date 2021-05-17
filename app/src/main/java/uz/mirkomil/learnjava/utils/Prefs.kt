import android.content.Context


object Prefs {
    const val prefsName = "InTalim"
    const val prefs = "prefs"
    const val token = "token"
    const val password = "password"
    const val user_id = "user_id"
    const val student_id = "student_id"
    const val email = "email"
    const val fullname = "fullname"
    const val info_user = "info_user"
    const val username = "username"
    const val region_user_uz = "region_user_uz"
    const val region_user_ru = "region_user_ru"
    const val region_user_en = "region_user_en"
    const val region_user_kr = "region_user_kr"
    const val region_user_qq = "region_user_qq"
    const val organization_user_uz = "organization_user_uz"
    const val organization_id = "organization_id"
    const val organization_user_ru = "organization_user_ru"
    const val organization_user_en = "organization_user_en"
    const val organization_user_kr = "organization_user_kr"
    const val organization_user_qq = "organization_user_qq"
    const val theme = "theme"
    const val language = "language"
    const val edu_type_id = "edu_type_id"
    const val edu_type_name_uz = "edu_type_name_uz"
    const val edu_type_name_ru = "edu_type_name_ru"
    const val edu_type_name_en = "edu_type_name_en"
    const val edu_type_name_kr = "edu_type_name_kr"
    const val edu_type_name_qq = "edu_type_name_qq"
    const val user_image_url = "user_image_url"
    const val proxy_server_name = "proxy_server_name"
    const val proxy_port = "proxy_port"
    const val proxy_user_name = "proxy_user_name"
    const val proxy_password = "proxy_password"
    const val fontSize = "fontSize"
    const val current_position = "current_position"
    const val testFontSize = "testFontSize"
    const val autoDownload = "autoDownload"
    const val version = "version"
    

    fun save(context: Context?, key: String, value: Int) {
        context?.getSharedPreferences(prefs, Context.MODE_PRIVATE)
            ?.edit()
            ?.putInt(key, value)
            ?.apply()
    }

    fun save(context: Context?, key: String, value: String) {
        context?.getSharedPreferences(prefs, Context.MODE_PRIVATE)
            ?.edit()
            ?.putString(key, value)
            ?.apply()
    }

    fun save(context: Context?, key: String, value: Float) {
        context?.getSharedPreferences(prefs, Context.MODE_PRIVATE)
            ?.edit()
            ?.putFloat(key, value)
            ?.apply()
    }

    fun save(context: Context?, key: String, value: Long) {
        context?.getSharedPreferences(prefs, Context.MODE_PRIVATE)
            ?.edit()
            ?.putLong(key, value)
            ?.apply()
    }

    fun save(context: Context?, key: String, value: Boolean) {
        context?.getSharedPreferences(prefs, Context.MODE_PRIVATE)
            ?.edit()
            ?.putBoolean(key, value)
            ?.apply()
    }

    fun get(context: Context?, key: String, default: Boolean) =
        context?.getSharedPreferences(prefs, Context.MODE_PRIVATE)
            ?.getBoolean(key, default) ?: default

    fun get(context: Context?, key: String, default: Float) =
        context?.getSharedPreferences(prefs, Context.MODE_PRIVATE)
            ?.getFloat(key, default) ?: default

    fun get(context: Context?, key: String, default: String) =
        context?.getSharedPreferences(prefs, Context.MODE_PRIVATE)
            ?.getString(key, default) ?: default

    fun get(context: Context?, key: String, default: Long) =
        context?.getSharedPreferences(prefs, Context.MODE_PRIVATE)
            ?.getLong(key, default) ?: default

    fun get(context: Context?, key: String, default: Int) =
        context?.getSharedPreferences(prefs, Context.MODE_PRIVATE)
            ?.getInt(key, default) ?: default

    fun clear(context: Context?) {
        val sharedPreferences = context?.getSharedPreferences(prefs, Context.MODE_PRIVATE)
        val editor = sharedPreferences?.edit()
        editor?.clear()
        editor?.apply()
    }
}