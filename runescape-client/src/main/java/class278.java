import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jh")
public class class278 extends CacheableNode {
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Ljr;"
   )
   static IndexDataBase field3549;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lhi;"
   )
   public static NodeCache field3545;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1389761971
   )
   static int field3550;
   @ObfuscatedName("b")
   char field3544;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1401797463
   )
   public int field3546;
   @ObfuscatedName("n")
   public String field3548;
   @ObfuscatedName("l")
   boolean field3551;

   static {
      field3545 = new NodeCache(64);
   }

   class278() {
      this.field3551 = true;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1709183454"
   )
   void method4990() {
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgg;B)V",
      garbageValue = "-82"
   )
   void method4991(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4992(var1, var2);
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Lgg;II)V",
      garbageValue = "-401612748"
   )
   void method4992(Buffer var1, int var2) {
      if(var2 == 1) {
         this.field3544 = MapIcon.method598(var1.readByte());
      } else if(var2 == 2) {
         this.field3546 = var1.readInt();
      } else if(var2 == 4) {
         this.field3551 = false;
      } else if(var2 == 5) {
         this.field3548 = var1.readString();
      }

   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "-599025311"
   )
   public boolean method4993() {
      return this.field3544 == 's';
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lee;II)V",
      garbageValue = "-1955281571"
   )
   public static final void method5005(Model var0, int var1) {
      for(int var2 = 0; var2 < var0.indicesCount; ++var2) {
         if(var0.field1835[var2] != -2) {
            int var3 = var0.indices1[var2];
            int var4 = var0.indices2[var2];
            int var5 = var0.indices3[var2];
            int var6 = Model.modelViewportYs[var3];
            int var7 = Model.modelViewportYs[var4];
            int var8 = Model.modelViewportYs[var5];
            int var9 = Model.modelViewportXs[var3];
            int var10 = Model.modelViewportXs[var4];
            int var11 = Model.modelViewportXs[var5];
            int var12 = Math.min(var6, Math.min(var7, var8)) - var1;
            int var13 = Math.max(var6, Math.max(var7, var8)) + var1;
            int var14 = Math.min(var9, Math.min(var10, var11)) - var1;
            int var15 = Math.max(var9, Math.max(var10, var11)) + var1;
            MapIcon.method597(var12, var14, var13, var15, -49088);
         }
      }

   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "46"
   )
   static final void method5004(String var0) {
      StringBuilder var10000 = new StringBuilder();
      Object var10001 = null;
      var10000 = var10000.append("Please remove ").append(var0);
      var10001 = null;
      String var1 = var10000.append(" from your friend list first").toString();
      ChatPlayer.sendGameMessage(30, "", var1);
   }
}
