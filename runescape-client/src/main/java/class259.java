import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("in")
public class class259 extends CacheableNode {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lij;"
   )
   public static IndexDataBase field3445;
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   static NodeCache field3442;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 2071562529
   )
   public static int field3447;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = 1270893037
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Lgu;"
   )
   IterableHashTable field3444;

   static {
      field3442 = new NodeCache(64);
   }

   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-404135432"
   )
   void method4440() {
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Lfs;I)V",
      garbageValue = "1838796366"
   )
   void method4459(Buffer var1) {
      while(true) {
         int var2 = var1.readUnsignedByte();
         if(var2 == 0) {
            return;
         }

         this.method4441(var1, var2);
      }
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lfs;II)V",
      garbageValue = "-92739039"
   )
   void method4441(Buffer var1, int var2) {
      if(var2 == 249) {
         this.field3444 = class27.method203(var1, this.field3444);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "178654026"
   )
   public int method4442(int var1, int var2) {
      return CombatInfo2.method4400(this.field3444, var1, var2);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILjava/lang/String;I)Ljava/lang/String;",
      garbageValue = "-1294164673"
   )
   public String method4448(int var1, String var2) {
      return ChatLineBuffer.method1852(this.field3444, var1, var2);
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1220094175"
   )
   static void method4461(int var0) {
      ItemContainer var1 = (ItemContainer)ItemContainer.itemContainers.get((long)var0);
      if(var1 != null) {
         var1.unlink();
      }
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lks;B)V",
      garbageValue = "6"
   )
   static final void method4460(IndexedSprite var0) {
      short var1 = 256;

      int var2;
      for(var2 = 0; var2 < class164.field2208.length; ++var2) {
         class164.field2208[var2] = 0;
      }

      int var3;
      for(var2 = 0; var2 < 5000; ++var2) {
         var3 = (int)(Math.random() * 128.0D * (double)var1);
         class164.field2208[var3] = (int)(Math.random() * 256.0D);
      }

      int var4;
      int var5;
      for(var2 = 0; var2 < 20; ++var2) {
         for(var3 = 1; var3 < var1 - 1; ++var3) {
            for(var4 = 1; var4 < 127; ++var4) {
               var5 = var4 + (var3 << 7);
               class91.field1364[var5] = (class164.field2208[var5 - 128] + class164.field2208[var5 + 1] + class164.field2208[var5 + 128] + class164.field2208[var5 - 1]) / 4;
            }
         }

         int[] var8 = class164.field2208;
         class164.field2208 = class91.field1364;
         class91.field1364 = var8;
      }

      if(var0 != null) {
         var2 = 0;

         for(var3 = 0; var3 < var0.height; ++var3) {
            for(var4 = 0; var4 < var0.originalWidth; ++var4) {
               if(var0.pixels[var2++] != 0) {
                  var5 = var4 + var0.offsetX + 16;
                  int var6 = var3 + var0.offsetY + 16;
                  int var7 = var5 + (var6 << 7);
                  class164.field2208[var7] = 0;
               }
            }
         }
      }

   }
}
