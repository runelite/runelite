import org.json.JSONArray
import org.json.JSONObject

class JsonBuilder() {
    private var json = JSONObject()

    constructor(vararg pairs: Pair<String, *>) : this() {
        add(*pairs)
    }

    fun add(vararg pairs: Pair<String, *>) {
        for ((key, value) in pairs) {
            when (value) {
                is Boolean -> json.put(key, value)
                is Number -> add(key, value)
                is String -> json.put(key, value)
                is JsonBuilder -> json.put(key, value.json)
                is Array<*> -> add(key, value)
                is JSONObject -> json.put(key, value)
                is JSONArray -> json.put(key, value)
            }
        }
    }

    fun add(key: String, value: Number): JsonBuilder {
        when (value) {
            is Int -> json.put(key, value)
            is Long -> json.put(key, value)
            is Float -> json.put(key, value)
            is Double -> json.put(key, value)
            else -> {}
        }

        return this
    }

    fun <T> add(key: String, items: Array<T>): JsonBuilder {
        val jsonArray = JSONArray()
        items.forEach {
            when (it) {
                is String,is Long,is Int, is Boolean -> jsonArray.put(it)
                is JsonBuilder -> jsonArray.put(it.json)
                else -> try {jsonArray.put(it)} catch (ignored:Exception) {

                }
            }
        }

        json.put(key, jsonArray)

        return this
    }

    override fun toString() = json.toString()
}