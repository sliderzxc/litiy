package com.sliderzxc.wixy.processor

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.symbol.KSAnnotated
import com.sliderzxc.wixy.annotation.WixyModule
import com.sliderzxc.wixy.annotation.utils.findAnnotations

class WixyProcessor(
    private val environment: SymbolProcessorEnvironment,
) : SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val listedFunctions = resolver.findAnnotations(WixyModule::class)
        println(listedFunctions.joinToString("\n"))
        return listedFunctions.toList()
    }
}
