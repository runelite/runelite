import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ef")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("ck")
   @ObfuscatedGetter(
      intValue = 1906631819
   )
   @Export("modelHeight")
   public int modelHeight;

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "([BI)V",
      garbageValue = "-1395520239"
   )
   static void method2869(byte[] var0) {
      Buffer var1 = new Buffer(var0);
      var1.offset = var0.length - 2;
      class286.field3792 = var1.readUnsignedShort();
      class95.field1493 = new int[class286.field3792];
      class286.field3790 = new int[class286.field3792];
      class286.field3793 = new int[class286.field3792];
      class241.field3293 = new int[class286.field3792];
      class31.field449 = new byte[class286.field3792][];
      var1.offset = var0.length - 7 - class286.field3792 * 8;
      NPC.field1377 = var1.readUnsignedShort();
      class286.field3791 = var1.readUnsignedShort();
      int var2 = (var1.readUnsignedByte() & 255) + 1;

      int var3;
      for(var3 = 0; var3 < class286.field3792; ++var3) {
         class95.field1493[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class286.field3792; ++var3) {
         class286.field3790[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class286.field3792; ++var3) {
         class286.field3793[var3] = var1.readUnsignedShort();
      }

      for(var3 = 0; var3 < class286.field3792; ++var3) {
         class241.field3293[var3] = var1.readUnsignedShort();
      }

      var1.offset = var0.length - 7 - class286.field3792 * 8 - (var2 - 1) * 3;
      class174.field2410 = new int[var2];

      for(var3 = 1; var3 < var2; ++var3) {
         class174.field2410[var3] = var1.read24BitInt();
         if(class174.field2410[var3] == 0) {
            class174.field2410[var3] = 1;
         }
      }

      var1.offset = 0;

      for(var3 = 0; var3 < class286.field3792; ++var3) {
         int var4 = class286.field3793[var3];
         int var5 = class241.field3293[var3];
         int var6 = var4 * var5;
         byte[] var7 = new byte[var6];
         class31.field449[var3] = var7;
         int var8 = var1.readUnsignedByte();
         int var9;
         if(var8 == 0) {
            for(var9 = 0; var9 < var6; ++var9) {
               var7[var9] = var1.readByte();
            }
         } else if(var8 == 1) {
            for(var9 = 0; var9 < var4; ++var9) {
               for(int var10 = 0; var10 < var5; ++var10) {
                  var7[var10 * var4 + var9] = var1.readByte();
               }
            }
         }
      }

   }

   @ObfuscatedName("cd")
   void vmethod2870(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(var10 != null) {
         this.modelHeight = var10.modelHeight;
         var10.vmethod2870(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(S)LModel;",
      garbageValue = "-1617"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   protected Renderable() {
      this.modelHeight = 1000;
   }
}
