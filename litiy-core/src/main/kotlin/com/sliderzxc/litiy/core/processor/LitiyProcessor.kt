package com.sliderzxc.litiy.core.processor

import com.google.devtools.ksp.processing.Resolver
import com.google.devtools.ksp.processing.SymbolProcessor
import com.google.devtools.ksp.processing.SymbolProcessorEnvironment
import com.google.devtools.ksp.symbol.KSAnnotated
import com.sliderzxc.litiy.core.annotation.LitiyModule
import com.sliderzxc.litiy.core.annotation.utils.findAnnotations

class LitiyProcessor(
    private val environment: SymbolProcessorEnvironment,
) : SymbolProcessor {
    override fun process(resolver: Resolver): List<KSAnnotated> {
        val listedFunctions = resolver.findAnnotations(LitiyModule::class)
        environment.logger.info("Hello WOrld")
        environment.logger.info(listedFunctions.joinToString("\n"))
        return listedFunctions.toList()
    }
}
