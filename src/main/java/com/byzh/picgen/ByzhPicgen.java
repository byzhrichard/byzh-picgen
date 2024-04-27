package com.byzh.picgen;

import com.byzh.picgen.block.ModBlocks;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class ByzhPicgen implements ModInitializer {

	public static final String MOD_ID = "byzh-picgen";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {

		ModBlocks.registerModBlocks();
		LOGGER.info("Hello Fabric world!");
	}
}