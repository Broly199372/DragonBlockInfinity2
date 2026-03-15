// Made with Blockbench 5.0.7
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports


public class unknown<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(new ResourceLocation("modid", "unknown"), "main");
	private final ModelPart tail1s;
	private final ModelPart tail2s;
	private final ModelPart tail3s;
	private final ModelPart tail4s;
	private final ModelPart tail5s;
	private final ModelPart tail6s;

	public unknown(ModelPart root) {
		this.tail1s = root.getChild("tail1s");
		this.tail2s = root.getChild("tail2s");
		this.tail3s = root.getChild("tail3s");
		this.tail4s = root.getChild("tail4s");
		this.tail5s = root.getChild("tail5s");
		this.tail6s = root.getChild("tail6s");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition tail1s = partdefinition.addOrReplaceChild("tail1s", CubeListBuilder.create().texOffs(0, 0).addBox(-0.875F, -1.0F, -1.5F, 1.5F, 1.5F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.125F, 9.95F, 2.75F));

		PartDefinition tail2s = partdefinition.addOrReplaceChild("tail2s", CubeListBuilder.create().texOffs(0, 5).addBox(-0.75F, -0.75F, -1.5F, 1.5F, 1.5F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.25F, 9.7F, 5.5F));

		PartDefinition tail3s = partdefinition.addOrReplaceChild("tail3s", CubeListBuilder.create().texOffs(0, 10).addBox(-0.75F, -0.75F, -1.5F, 1.5F, 1.5F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.25F, 9.7F, 8.25F));

		PartDefinition tail4s = partdefinition.addOrReplaceChild("tail4s", CubeListBuilder.create().texOffs(10, 0).addBox(-0.75F, -0.75F, -1.5F, 1.5F, 1.5F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.25F, 9.7F, 11.0F));

		PartDefinition tail5s = partdefinition.addOrReplaceChild("tail5s", CubeListBuilder.create().texOffs(10, 5).addBox(-0.75F, -0.75F, -1.5F, 1.5F, 1.5F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.25F, 9.7F, 13.75F));

		PartDefinition tail6s = partdefinition.addOrReplaceChild("tail6s", CubeListBuilder.create().texOffs(10, 10).addBox(-0.75F, -0.75F, -1.5F, 1.5F, 1.5F, 3.0F, new CubeDeformation(0.0F)), PartPose.offset(-0.25F, 9.7F, 16.5F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void setupAnim(Entity entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw, float headPitch) {

	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay, float red, float green, float blue, float alpha) {
		tail1s.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail2s.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail3s.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail4s.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail5s.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		tail6s.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}
}