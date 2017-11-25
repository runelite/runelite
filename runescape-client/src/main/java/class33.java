import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class33 {
   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "Ldc;"
   )
   @Export("task")
   static SoundTask task;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lkl;"
   )
   static IndexedSprite field446;
   @ObfuscatedName("fz")
   @ObfuscatedSignature(
      signature = "[Lky;"
   )
   @Export("headIconsHint")
   static SpritePixels[] headIconsHint;
   @ObfuscatedName("d")
   String field442;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = -783482665
   )
   int field441;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      intValue = 369279265
   )
   int field445;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lg;"
   )
   class24 field443;

   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;IILg;)V"
   )
   class33(String var1, int var2, int var3, class24 var4) {
      this.field442 = var1;
      this.field441 = var2;
      this.field445 = var3;
      this.field443 = var4;
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lid;Lid;IZB)Lej;",
      garbageValue = "-92"
   )
   public static Frames method359(IndexDataBase var0, IndexDataBase var1, int var2, boolean var3) {
      boolean var4 = true;
      int[] var5 = var0.getChilds(var2);

      for(int var6 = 0; var6 < var5.length; ++var6) {
         byte[] var7 = var0.getChild(var2, var5[var6]);
         if(var7 == null) {
            var4 = false;
         } else {
            int var8 = (var7[0] & 255) << 8 | var7[1] & 255;
            byte[] var9;
            if(var3) {
               var9 = var1.getChild(0, var8);
            } else {
               var9 = var1.getChild(var8, 0);
            }

            if(var9 == null) {
               var4 = false;
            }
         }
      }

      if(!var4) {
         return null;
      } else {
         try {
            return new Frames(var0, var1, var2, var3);
         } catch (Exception var11) {
            return null;
         }
      }
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "-495685061"
   )
   public static int method360(int var0, int var1) {
      int var2;
      if(var1 > var0) {
         var2 = var0;
         var0 = var1;
         var1 = var2;
      }

      while(var1 != 0) {
         var2 = var0 % var1;
         var0 = var1;
         var1 = var2;
      }

      return var0;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;II)Z",
      garbageValue = "-320206495"
   )
   static boolean method358(String var0, int var1) {
      return ClanMember.method1188(var0, var1, "openjs");
   }
}
