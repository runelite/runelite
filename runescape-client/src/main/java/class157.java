import java.io.File;
import java.util.Hashtable;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fk")
public class class157 {
   @ObfuscatedName("d")
   static boolean field2232;
   @ObfuscatedName("x")
   static Hashtable field2235;
   @ObfuscatedName("q")
   static File field2233;

   static {
      field2232 = false;
      field2235 = new Hashtable(16);
   }

   @ObfuscatedName("gn")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "563490659"
   )
   static final void method2998(int var0) {
      int[] var1 = KeyFocusListener.field619.image;
      int var2 = var1.length;

      int var3;
      for(var3 = 0; var3 < var2; ++var3) {
         var1[var3] = 0;
      }

      int var4;
      int var5;
      for(var3 = 1; var3 < 103; ++var3) {
         var4 = (103 - var3) * 2048 + 24628;

         for(var5 = 1; var5 < 103; ++var5) {
            if((class62.tileSettings[var0][var5][var3] & 24) == 0) {
               class51.region.method2733(var1, var4, 512, var0, var5, var3);
            }

            if(var0 < 3 && (class62.tileSettings[var0 + 1][var5][var3] & 8) != 0) {
               class51.region.method2733(var1, var4, 512, var0 + 1, var5, var3);
            }

            var4 += 4;
         }
      }

      var3 = (238 + (int)(Math.random() * 20.0D) - 10 << 16) + (238 + (int)(Math.random() * 20.0D) - 10 << 8) + (238 + (int)(Math.random() * 20.0D) - 10);
      var4 = 238 + (int)(Math.random() * 20.0D) - 10 << 16;
      KeyFocusListener.field619.method5060();

      int var6;
      for(var5 = 1; var5 < 103; ++var5) {
         for(var6 = 1; var6 < 103; ++var6) {
            if((class62.tileSettings[var0][var6][var5] & 24) == 0) {
               class174.method3393(var0, var6, var5, var3, var4);
            }

            if(var0 < 3 && (class62.tileSettings[var0 + 1][var6][var5] & 8) != 0) {
               class174.method3393(var0 + 1, var6, var5, var3, var4);
            }
         }
      }

      Client.field1112 = 0;

      for(var5 = 0; var5 < 104; ++var5) {
         for(var6 = 0; var6 < 104; ++var6) {
            int var7 = class51.region.method2699(class8.plane, var5, var6);
            if(var7 != 0) {
               var7 = var7 >> 14 & 32767;
               int var8 = WidgetNode.getObjectDefinition(var7).mapIconId;
               if(var8 >= 0) {
                  Client.field1127[Client.field1112] = Area.field3286[var8].method4271(false);
                  Client.field1113[Client.field1112] = var5;
                  Client.field1114[Client.field1112] = var6;
                  ++Client.field1112;
               }
            }
         }
      }

      class48.field582.setRaster();
   }
}
