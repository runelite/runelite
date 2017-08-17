import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hq")
public class class212 {
   @ObfuscatedName("j")
   static int[] field2602;
   @ObfuscatedName("h")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("f")
   @Export("widgetSettings")
   public static int[] widgetSettings;
   @ObfuscatedName("dc")
   @ObfuscatedSignature(
      signature = "Lil;"
   )
   static IndexData field2606;
   @ObfuscatedName("qm")
   static short[] field2607;

   static {
      field2602 = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2602[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }

   @ObfuscatedName("h")
   @ObfuscatedSignature(
      signature = "(IIIIIIIB)V",
      garbageValue = "-57"
   )
   static final void method3937(int var0, int var1, int var2, int var3, int var4, int var5, int var6) {
      int var7 = Math.min(var3, Math.min(var4, var5)) - var6;
      int var8 = Math.max(var3, Math.max(var4, var5)) + var6;
      int var9 = Math.min(var0, Math.min(var1, var2)) - var6;
      int var10 = Math.max(var0, Math.max(var1, var2)) + var6;
      class1.method0(var7, var9, var8, var10, -49088);
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(ILhn;I)Lcj;",
      garbageValue = "2105583240"
   )
   static Script method3936(int var0, class220 var1) {
      Script var2 = (Script)Script.field1548.get((long)(var0 << 16));
      if(var2 != null) {
         return var2;
      } else {
         String var3 = String.valueOf(var0);
         int var4 = FrameMap.indexScripts.getFile(var3);
         if(var4 == -1) {
            return null;
         } else {
            byte[] var5 = FrameMap.indexScripts.method4119(var4);
            if(var5 != null) {
               if(var5.length <= 1) {
                  return null;
               }

               var2 = class27.method233(var5);
               if(var2 != null) {
                  Script.field1548.put(var2, (long)(var0 << 16));
                  return var2;
               }
            }

            return null;
         }
      }
   }
}
