/**
 * This class was created by <wiiv>. It's distributed as
 * part of the Botania Mod. Get the Source Code in github:
 * https://github.com/Vazkii/Botania
 *
 * Botania is Open Source and distributed under the
 * Botania License: http://botaniamod.net/license.php
 *
 * File Created @ [? (GMT)]
 */
package vazkii.botania.client.model.armor;

import net.minecraft.client.renderer.entity.model.RendererModel;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.inventory.EquipmentSlotType;

import javax.annotation.Nonnull;

public class ModelArmorManasteel extends ModelArmor {
	
	private final RendererModel helmAnchor;
	private final RendererModel helm;
    private final RendererModel helmTop;
    private final RendererModel helmCrystal;
    
	private final RendererModel bodyAnchor;
	private final RendererModel bodyTop;
	private final RendererModel bodyBottom;
	
	private final RendererModel armLAnchor;
	private final RendererModel armL;
	private final RendererModel armLpauldron;
	private final RendererModel armLcrystal;
    
	private final RendererModel armRAnchor;
	private final RendererModel armR;
	private final RendererModel armRpauldron;
    private final RendererModel armRcrystal;
	private final RendererModel pantsAnchor;
	private final RendererModel belt;
    private final RendererModel legL;
    private final RendererModel legR;
    
    private final RendererModel bootL;
    private final RendererModel bootLcrystal;
    private final RendererModel bootR;
	private final RendererModel bootRcrystal;
    
	public ModelArmorManasteel(EquipmentSlotType slot) {
		super(slot);

		this.textureWidth = 64;
        this.textureHeight = 128;
		float s = 0.01F;
		
		//helm
        this.helmAnchor = new RendererModel(this, 0, 0);
        this.helmAnchor.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.helmAnchor.addBox(-1.0F, -2.0F, 0.0F, 2, 2, 2, s);
        this.helm = new RendererModel(this, 0, 0);
        this.helm.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.helm.addBox(-4.5F, -8.5F, -4.5F, 9, 9, 9, s);
        this.helmTop = new RendererModel(this, 36, 6);
        this.helmTop.setRotationPoint(0.0F, -8.5F, 3.5F);
        this.helmTop.addBox(-1.5F, 0.0F, -7.0F, 3, 3, 7, s);
        this.setRotateAngle(helmTop, -0.2617993877991494F, 0.0F, 0.0F);
        this.helmCrystal = new RendererModel(this, 36, 0);
        this.helmCrystal.setRotationPoint(0.0F, -7.5F, -4.5F);
        this.helmCrystal.addBox(-1.5F, -4.0F, -1.0F, 3, 5, 1, s);
        this.setRotateAngle(helmCrystal, 0.08726646259971647F, 0.0F, 0.0F);
        
        //body
        this.bodyAnchor = new RendererModel(this, 0, 0);
        this.bodyAnchor.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bodyAnchor.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, s);
        this.bodyTop = new RendererModel(this, 0, 18);
        this.bodyTop.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bodyTop.addBox(-4.5F, -0.5F, -3.0F, 9, 6, 6, s);
        this.setRotateAngle(bodyTop, 0.0F, 0.0F, 0.0F);
        this.bodyBottom = new RendererModel(this, 0, 30);
        this.bodyBottom.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.bodyBottom.addBox(-2.5F, 5.5F, -2.5F, 5, 3, 5, 0.0F);
        
     	//armL
        this.armLAnchor = new RendererModel(this, 0, 0);
        this.armLAnchor.mirror = true;
        this.armLAnchor.setRotationPoint(4.0F, 2.0F, 0.0F);
        this.armLAnchor.addBox(0.0F, -1.0F, -1.0F, 2, 2, 2, s);
        this.armL = new RendererModel(this, 22, 40);
        this.armL.mirror = true;
        this.armL.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armL.addBox(1.5F, 2.0F, -2.49F, 2, 6, 5, s);
        this.armLpauldron = new RendererModel(this, 0, 40);
        this.armLpauldron.mirror = true;
        this.armLpauldron.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armLpauldron.addBox(-0.5F, -3.0F, -3.0F, 5, 4, 6, s);
        this.armLcrystal = new RendererModel(this, 36, 40);
        this.armLcrystal.mirror = true;
        this.armLcrystal.setRotationPoint(2.0F, -2.5F, 0.0F);
        this.armLcrystal.addBox(-0.5F, -2.5F, -1.5F, 2, 3, 3, s);
        this.setRotateAngle(armLcrystal, 0.0F, 0.0F, -0.08726646259971647F);
        
        //armR
        this.armRAnchor = new RendererModel(this, 0, 0);
        this.armRAnchor.mirror = true;
        this.armRAnchor.setRotationPoint(-4.0F, 2.0F, 0.0F);
        this.armRAnchor.addBox(-2.0F, -1.0F, -1.0F, 2, 2, 2, s);
        this.armR = new RendererModel(this, 22, 40);
        this.armR.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armR.addBox(-3.5F, 2.0F, -2.51F, 2, 6, 5, s);
        this.armRpauldron = new RendererModel(this, 0, 40);
        this.armRpauldron.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.armRpauldron.addBox(-4.5F, -3.0F, -3.0F, 5, 4, 6, s);
        this.armRcrystal = new RendererModel(this, 36, 40);
        this.armRcrystal.setRotationPoint(-2.0F, -2.5F, 0.0F);
        this.armRcrystal.addBox(-1.5F, -2.5F, -1.5F, 2, 3, 3, s);
        this.setRotateAngle(armRcrystal, 0.0F, 0.0F, 0.08726646259971647F);
        
        //pants
        this.pantsAnchor = new RendererModel(this, 0, 0);
        this.pantsAnchor.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.pantsAnchor.addBox(-1.0F, 0.0F, -1.0F, 2, 2, 2, s);
        this.belt = new RendererModel(this, 0, 51);
        this.belt.setRotationPoint(0.0F, 0.0F, 0.0F);
        this.belt.addBox(-4.5F, 9.0F, -3.0F, 9, 3, 6, s);
        this.legL = new RendererModel(this, 0, 60);
        this.legL.mirror = true;
        this.legL.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.legL.addBox(-0.39F, 0.0F, -2.49F, 3, 6, 5, s);
        this.legR = new RendererModel(this, 0, 60);
        this.legR.setRotationPoint(-1.9F, 12.0F, 0.0F);
        this.legR.addBox(-2.61F, 0.0F, -2.51F, 3, 6, 5, s);
        
        //boots
        this.bootL = new RendererModel(this, 0, 71);
        this.bootL.mirror = true;
        this.bootL.setRotationPoint(1.9F, 12.0F, 0.0F);
        this.bootL.addBox(-2.39F, 8.5F, -2.49F, 5, 4, 5, s);
        this.bootLcrystal = new RendererModel(this, 36, 46);
        this.bootLcrystal.mirror = true;
        this.bootLcrystal.setRotationPoint(2.5F, 9.0F, 2.0F);
        this.bootLcrystal.addBox(-1.0F, -2.0F, -1.5F, 2, 3, 3, s);
        this.setRotateAngle(bootLcrystal, 0.0F, 0.0F, 0.08726646259971647F);
        this.bootR = new RendererModel(this, 0, 71);
        this.bootR.setRotationPoint(-2.0F, 12.0F, 0.0F);
        this.bootR.addBox(-2.5F, 8.5F, -2.51F, 5, 4, 5, s);
        this.bootRcrystal = new RendererModel(this, 36, 46);
        this.bootRcrystal.setRotationPoint(-2.5F, 9.0F, 2.0F);
        this.bootRcrystal.addBox(-1.0F, -2.0F, -1.5F, 2, 3, 3, s);
        this.setRotateAngle(bootRcrystal, 0.0F, 0.0F, -0.08726646259971647F);
        
        //hierarchy
        this.helmAnchor.addChild(this.helm);
        this.helm.addChild(this.helmTop);
        this.helm.addChild(this.helmCrystal);
        
        this.bodyAnchor.addChild(this.bodyTop);
        this.bodyTop.addChild(this.bodyBottom);
        this.armLAnchor.addChild(this.armL);
        this.armL.addChild(this.armLpauldron);
        this.armLpauldron.addChild(this.armLcrystal);
        this.armRAnchor.addChild(this.armR);
        this.armR.addChild(this.armRpauldron);
        this.armRpauldron.addChild(this.armRcrystal);
        
        this.pantsAnchor.addChild(this.belt);
        this.belt.addChild(this.legL);
        this.belt.addChild(this.legR);;
        
        this.bootL.addChild(bootLcrystal);
        this.bootR.addChild(bootRcrystal);
	}

	@Override
	public void render(@Nonnull LivingEntity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch, float scale) {

		helmAnchor.showModel = slot == EquipmentSlotType.HEAD;
		bodyAnchor.showModel = slot == EquipmentSlotType.CHEST;
		armRAnchor.showModel = slot == EquipmentSlotType.CHEST;
		armLAnchor.showModel = slot == EquipmentSlotType.CHEST;
		legR.showModel = slot == EquipmentSlotType.LEGS;
		legL.showModel = slot == EquipmentSlotType.LEGS;
		bootL.showModel = slot == EquipmentSlotType.FEET;
		bootR.showModel = slot == EquipmentSlotType.FEET;
		bipedHeadwear.showModel = false;

		bipedHead = helmAnchor;
		bipedBody = bodyAnchor;
		bipedRightArm = armRAnchor;
		bipedLeftArm = armLAnchor;
		if(slot == EquipmentSlotType.LEGS) {
			bipedBody = pantsAnchor;
			bipedRightLeg = legR;
			bipedLeftLeg = legL;
		} else {
			bipedRightLeg = bootR;
			bipedLeftLeg = bootL;
		}

		super.render(entity, limbSwing, limbSwingAmount, ageInTicks, netHeadYaw, headPitch, scale);
	}
}