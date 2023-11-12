package com.sliderzxc.wixy.annotation.utils

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.symbol.KSAnnotated
import kotlin.reflect.KClass

fun Resolver.findAnnotations(
    kClass: KClass<*>,
): Sequence<KSAnnotated> {
    return getSymbolsWithAnnotation(
        kClass.qualifiedName.toString()
    )
}