import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ad")
public class class40 {
   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "Lad;"
   )
   public static final class40 field514;
   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "Lad;"
   )
   public static final class40 field515;
   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "Lad;"
   )
   public static final class40 field516;
   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "Lad;"
   )
   public static final class40 field519;
   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "Lad;"
   )
   public static final class40 field518;
   @ObfuscatedName("m")
   public final String field517;

   static {
      field514 = new class40("details");
      field515 = new class40("compositemap");
      field516 = new class40("compositetexture");
      field519 = new class40("area");
      field518 = new class40("labels");
   }

   class40(String var1) {
      this.field517 = var1;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(IIIZIZS)V",
      garbageValue = "17214"
   )
   static void method555(int var0, int var1, int var2, boolean var3, int var4, boolean var5) {
      if(var0 < var1) {
         int var6 = (var0 + var1) / 2;
         int var7 = var0;
         World var8 = World.worldList[var6];
         World.worldList[var6] = World.worldList[var1];
         World.worldList[var1] = var8;

         for(int var9 = var0; var9 < var1; ++var9) {
            World var11 = World.worldList[var9];
            int var12 = class87.method1761(var11, var8, var2, var3);
            int var10;
            if(var12 != 0) {
               if(var3) {
                  var10 = -var12;
               } else {
                  var10 = var12;
               }
            } else if(var4 == -1) {
               var10 = 0;
            } else {
               int var13 = class87.method1761(var11, var8, var4, var5);
               if(var5) {
                  var10 = -var13;
               } else {
                  var10 = var13;
               }
            }

            if(var10 <= 0) {
               World var14 = World.worldList[var9];
               World.worldList[var9] = World.worldList[var7];
               World.worldList[var7++] = var14;
            }
         }

         World.worldList[var1] = World.worldList[var7];
         World.worldList[var7] = var8;
         method555(var0, var7 - 1, var2, var3, var4, var5);
         method555(var7 + 1, var1, var2, var3, var4, var5);
      }

   }

   @ObfuscatedName("jd")
   @ObfuscatedSignature(
      signature = "(Lhx;I)V",
      garbageValue = "-722893611"
   )
   static void method556(Widget var0) {
      if(var0.loopCycle == Client.field1058) {
         Client.field1059[var0.boundsIndex] = true;
      }

   }
}
