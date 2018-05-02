/*
 * Copyright (C) 2018 Lucio
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * Created by Lucio on 17/11/30.
 */
package halo.stdlib.kotlin.util

/**
 * @param printStack 异常时，是否调用printStackTrace方法
 */
inline fun <T> Try(printStack: Boolean = false, block: () -> T) = try {
    block()
} catch (e: Throwable) {
    if (printStack) {
        e.printStackTrace()
    }
    null
}

inline fun <T> Try(block: () -> T,
                   noinline exception: ((Throwable) -> T)? = null,
                   noinline finally: (() -> Unit)? = null)
        = try {
    block()
} catch (e: Throwable) {
    exception?.invoke(e)
} finally {
    finally?.invoke()
}
