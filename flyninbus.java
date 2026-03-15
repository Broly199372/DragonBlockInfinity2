// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class flyninbus<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "flyninbus"), "main");
	private final ModelPart root;
	private final ModelPart nubecita1;
	private final ModelPart nubecita3;
	private final ModelPart nubecita4;
	private final ModelPart nubecita5;
	private final ModelPart nubecita6;
	private final ModelPart nubecita7;
	private final ModelPart nubecita10;
	private final ModelPart nubecita11;
	private final ModelPart nubecita12;
	private final ModelPart nubecita13;
	private final ModelPart nubecita14;
	private final ModelPart nubecita15;
	private final ModelPart nubecita8;
	private final ModelPart nubecita9;
	private final ModelPart nubecita16;
	private final ModelPart nubecita17;
	private final ModelPart nubecita18;
	private final ModelPart nubecita2;
	private final ModelPart nubecita19;
	private final ModelPart nubecita20;
	private final ModelPart nubecita21;
	private final ModelPart nubecita22;
	private final ModelPart nubecita23;
	private final ModelPart nubecita24;
	private final ModelPart nubecita25;
	private final ModelPart nubecita26;
	private final ModelPart nubecita27;
	private final ModelPart nubecita28;
	private final ModelPart nubecita29;

	public flyninbus(ModelPart root) {
		this.root = root.getChild("root");
		this.nubecita1 = this.root.getChild("nubecita1");
		this.nubecita3 = this.root.getChild("nubecita3");
		this.nubecita4 = this.root.getChild("nubecita4");
		this.nubecita5 = this.root.getChild("nubecita5");
		this.nubecita6 = this.root.getChild("nubecita6");
		this.nubecita7 = this.root.getChild("nubecita7");
		this.nubecita10 = this.root.getChild("nubecita10");
		this.nubecita11 = this.root.getChild("nubecita11");
		this.nubecita12 = this.root.getChild("nubecita12");
		this.nubecita13 = this.root.getChild("nubecita13");
		this.nubecita14 = this.root.getChild("nubecita14");
		this.nubecita15 = this.root.getChild("nubecita15");
		this.nubecita8 = this.root.getChild("nubecita8");
		this.nubecita9 = this.root.getChild("nubecita9");
		this.nubecita16 = this.root.getChild("nubecita16");
		this.nubecita17 = this.root.getChild("nubecita17");
		this.nubecita18 = this.root.getChild("nubecita18");
		this.nubecita2 = this.root.getChild("nubecita2");
		this.nubecita19 = this.root.getChild("nubecita19");
		this.nubecita20 = this.root.getChild("nubecita20");
		this.nubecita21 = this.root.getChild("nubecita21");
		this.nubecita22 = this.root.getChild("nubecita22");
		this.nubecita23 = this.root.getChild("nubecita23");
		this.nubecita24 = this.root.getChild("nubecita24");
		this.nubecita25 = this.root.getChild("nubecita25");
		this.nubecita26 = this.root.getChild("nubecita26");
		this.nubecita27 = this.root.getChild("nubecita27");
		this.nubecita28 = this.root.getChild("nubecita28");
		this.nubecita29 = this.root.getChild("nubecita29");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition root = partdefinition.addOrReplaceChild("root", CubeListBuilder.create(), PartPose.offset(0.0F, 24.0F, -3.25F));

		PartDefinition nubecita1 = root.addOrReplaceChild("nubecita1", CubeListBuilder.create().texOffs(0, 33).addBox(-10.0F, -18.0F, -10.0F, 19.0F, 11.5F, 23.0F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 0.0F, 0.0F));

		PartDefinition nubecita3 = root.addOrReplaceChild("nubecita3", CubeListBuilder.create().texOffs(144, 132).addBox(-0.2F, -20.0F, -10.0F, 11.0F, 10.0F, 10.0F, new CubeDeformation(0.0F)), PartPose.offset(-2.25F, 2.75F, -3.0F));

		PartDefinition nubecita4 = root.addOrReplaceChild("nubecita4", CubeListBuilder.create(), PartPose.offset(-10.0F, -0.25F, -2.5F));

		PartDefinition nubecita4_r1 = nubecita4.addOrReplaceChild("nubecita4_r1", CubeListBuilder.create().texOffs(50, 93).addBox(-1.0F, -10.0F, -9.0F, 11.0F, 11.0F, 13.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-0.1F, -9.6F, 0.0F, 0.0F, 0.0F, 0.0436F));

		PartDefinition nubecita5 = root.addOrReplaceChild("nubecita5", CubeListBuilder.create().texOffs(0, 68).addBox(-1.0F, -19.0F, -11.0F, 11.0F, 10.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.75F, 3.0F, 5.25F));

		PartDefinition nubecita6 = root.addOrReplaceChild("nubecita6", CubeListBuilder.create().texOffs(0, 93).addBox(1.4F, -19.25F, -9.0F, 10.6F, 10.25F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-10.5F, 0.5F, 10.75F));

		PartDefinition nubecita7 = root.addOrReplaceChild("nubecita7", CubeListBuilder.create().texOffs(92, 0).addBox(-6.9F, -19.6F, -10.0F, 11.0F, 10.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(0.5F, 0.0F, 10.5F));

		PartDefinition nubecita10 = root.addOrReplaceChild("nubecita10", CubeListBuilder.create().texOffs(0, 0).addBox(-12.0F, -19.0F, -10.25F, 23.0F, 10.0F, 23.25F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.25F, -0.25F));

		PartDefinition nubecita11 = root.addOrReplaceChild("nubecita11", CubeListBuilder.create().texOffs(98, 93).addBox(-0.5F, -20.0F, -9.0F, 13.25F, 10.0F, 11.25F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.25F, -0.25F));

		PartDefinition nubecita12 = root.addOrReplaceChild("nubecita12", CubeListBuilder.create().texOffs(84, 33).addBox(-0.45F, -20.35F, -10.3F, 12.75F, 10.75F, 13.5F, new CubeDeformation(0.0F)), PartPose.offset(-5.75F, 1.5F, -3.5F));

		PartDefinition nubecita13 = root.addOrReplaceChild("nubecita13", CubeListBuilder.create(), PartPose.offset(-5.75F, 1.5F, -3.5F));

		PartDefinition nubecita14 = root.addOrReplaceChild("nubecita14", CubeListBuilder.create().texOffs(138, 24).addBox(-3.1F, -19.25F, -5.75F, 10.6F, 10.25F, 11.0F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(-8.6F, 0.5F, -3.25F, 0.0F, 0.0F, -0.0873F));

		PartDefinition nubecita15 = root.addOrReplaceChild("nubecita15", CubeListBuilder.create(), PartPose.offsetAndRotation(0.0F, -0.75F, -2.0F, 0.0F, 0.0F, 0.1309F));

		PartDefinition nubecita15_r1 = nubecita15.addOrReplaceChild("nubecita15_r1", CubeListBuilder.create().texOffs(0, 135).addBox(-2.0F, -10.1F, -7.0F, 12.0F, 10.1F, 10.5F, new CubeDeformation(0.0F)), PartPose.offsetAndRotation(1.5F, -8.65F, -2.0F, 0.0F, 0.0F, -0.2182F));

		PartDefinition nubecita8 = root.addOrReplaceChild("nubecita8", CubeListBuilder.create().texOffs(52, 117).addBox(0.0F, -18.0F, -16.0F, 9.0F, 6.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.25F, 0.0F, 19.5F));

		PartDefinition nubecita9 = root.addOrReplaceChild("nubecita9", CubeListBuilder.create().texOffs(142, 0).addBox(0.25F, -17.5F, -16.0F, 7.75F, 6.75F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-6.5F, 0.0F, 22.25F));

		PartDefinition nubecita16 = root.addOrReplaceChild("nubecita16", CubeListBuilder.create().texOffs(32, 159).addBox(4.4F, -16.5F, -12.0F, 3.0F, 4.75F, 11.5F, new CubeDeformation(0.0F)), PartPose.offset(-5.25F, 0.0F, 25.25F));

		PartDefinition nubecita17 = root.addOrReplaceChild("nubecita17", CubeListBuilder.create().texOffs(98, 132).addBox(0.0F, -18.0F, -16.0F, 9.0F, 6.0F, 14.0F, new CubeDeformation(0.0F)), PartPose.offset(-4.75F, 1.75F, 20.25F));

		PartDefinition nubecita18 = root.addOrReplaceChild("nubecita18", CubeListBuilder.create().texOffs(46, 137).addBox(3.4F, -19.25F, -7.4F, 9.6F, 10.25F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(-13.0F, -0.5F, 11.5F));

		PartDefinition nubecita2 = root.addOrReplaceChild("nubecita2", CubeListBuilder.create().texOffs(104, 58).addBox(3.7F, -19.25F, -9.4F, 9.6F, 9.25F, 13.5F, new CubeDeformation(0.0F)), PartPose.offset(-15.05F, 0.1F, 12.5F));

		PartDefinition nubecita19 = root.addOrReplaceChild("nubecita19", CubeListBuilder.create().texOffs(152, 65).addBox(2.7F, -18.95F, -11.4F, 7.6F, 6.25F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-15.25F, -1.25F, 12.25F));

		PartDefinition nubecita20 = root.addOrReplaceChild("nubecita20", CubeListBuilder.create().texOffs(146, 81).addBox(-0.95F, -19.0F, -8.0F, 8.0F, 10.0F, 12.0F, new CubeDeformation(0.0F)), PartPose.offset(2.5F, -0.5F, 11.25F));

		PartDefinition nubecita21 = root.addOrReplaceChild("nubecita21", CubeListBuilder.create().texOffs(0, 156).addBox(2.4F, -19.25F, -3.4F, 7.6F, 6.25F, 8.0F, new CubeDeformation(0.0F)), PartPose.offset(-8.0F, -0.75F, 9.0F));

		PartDefinition nubecita22 = root.addOrReplaceChild("nubecita22", CubeListBuilder.create().texOffs(98, 114).addBox(-3.65F, -18.25F, 4.5F, 15.5F, 8.25F, 9.75F, new CubeDeformation(0.0F)), PartPose.offset(0.0F, 1.25F, -0.25F));

		PartDefinition nubecita23 = root.addOrReplaceChild("nubecita23", CubeListBuilder.create().texOffs(132, 152).addBox(3.25F, -18.25F, 4.5F, 9.5F, 8.25F, 9.75F, new CubeDeformation(0.0F)), PartPose.offset(-1.5F, -2.0F, -5.75F));

		PartDefinition nubecita24 = root.addOrReplaceChild("nubecita24", CubeListBuilder.create().texOffs(150, 103).addBox(3.8F, -20.25F, -6.4F, 9.6F, 9.25F, 10.5F, new CubeDeformation(0.0F)), PartPose.offset(-15.55F, 2.6F, 13.0F));

		PartDefinition nubecita25 = root.addOrReplaceChild("nubecita25", CubeListBuilder.create().texOffs(0, 117).addBox(-3.95F, -19.65F, 5.0F, 15.5F, 8.25F, 9.75F, new CubeDeformation(0.0F)), PartPose.offset(-1.25F, 1.65F, 1.5F));

		PartDefinition nubecita26 = root.addOrReplaceChild("nubecita26", CubeListBuilder.create().texOffs(0, 170).addBox(4.4F, -16.0F, -12.0F, 3.0F, 3.75F, 11.5F, new CubeDeformation(0.0F)), PartPose.offset(-7.25F, 0.0F, 27.25F));

		PartDefinition nubecita27 = root.addOrReplaceChild("nubecita27", CubeListBuilder.create().texOffs(152, 45).addBox(1.4F, -21.15F, -11.45F, 9.6F, 9.25F, 10.5F, new CubeDeformation(0.0F)), PartPose.offset(0.45F, 2.6F, 13.0F));

		PartDefinition nubecita28 = root.addOrReplaceChild("nubecita28", CubeListBuilder.create().texOffs(90, 152).addBox(2.4F, -20.25F, -8.65F, 9.6F, 9.25F, 10.5F, new CubeDeformation(0.0F)), PartPose.offset(-8.3F, 3.85F, 13.05F));

		PartDefinition nubecita29 = root.addOrReplaceChild("nubecita29", CubeListBuilder.create().texOffs(52, 68).addBox(-1.0F, -19.0F, -11.0F, 11.0F, 10.0F, 15.0F, new CubeDeformation(0.0F)), PartPose.offset(-5.5F, 3.3F, 5.25F));

		return LayerDefinition.create(meshdefinition, 256, 256);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		root.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}