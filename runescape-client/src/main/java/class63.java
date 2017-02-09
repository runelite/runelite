import java.awt.event.ActionEvent;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bp")
public class class63 implements Runnable {
   @ObfuscatedName("o")
   volatile boolean field1091 = false;
   @ObfuscatedName("r")
   volatile boolean field1092 = false;
   @ObfuscatedName("pd")
   public static class103 field1093;
   @ObfuscatedName("y")
   volatile class57[] field1095 = new class57[2];
   @ObfuscatedName("k")
   class103 field1098;

   @ObfuscatedName("em")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)Z",
      garbageValue = "1641539885"
   )
   static boolean method1170(String var0, boolean var1) {
      if(var0 == null) {
         return false;
      } else {
         String var2 = Overlay.method3751(var0, Client.field282);

         for(int var3 = 0; var3 < Client.friendCount; ++var3) {
            if(var2.equalsIgnoreCase(Overlay.method3751(Client.friends[var3].name, Client.field282)) && (!var1 || Client.friends[var3].world != 0)) {
               return true;
            }
         }

         if(var2.equalsIgnoreCase(Overlay.method3751(VertexNormal.localPlayer.name, Client.field282))) {
            return true;
         } else {
            return false;
         }
      }
   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-382218669"
   )
   static final void method1173(int var0) {
      if(var0 >= 0) {
         int var1 = Client.menuActionParams0[var0];
         int var2 = Client.menuActionParams1[var0];
         int var3 = Client.menuTypes[var0];
         int var4 = Client.menuIdentifiers[var0];
         String var5 = Client.menuOptions[var0];
         String var6 = Client.menuTargets[var0];
         class0.menuAction(var1, var2, var3, var4, var5, var6, class115.field1800, class115.field1807);
      }
   }

   public void run() {
      this.field1092 = true;

      try {
         while(!this.field1091) {
            class57 var2;
            for(int var1 = 0; var1 < 2; ++var1) {
               var2 = this.field1095[var1];
               if(var2 != null) {
                  var2.method1094();
               }
            }

            class195.method3560(10L);
            class103 var5 = this.field1098;
            var2 = null;
            if(null != var5.field1681) {
               for(int var3 = 0; var3 < 50 && var5.field1681.peekEvent() != null; ++var3) {
                  class195.method3560(1L);
               }

               if(null != var2) {
                  var5.field1681.postEvent(new ActionEvent(var2, 1001, "dummy"));
               }
            }
         }
      } catch (Exception var8) {
         class32.method709((String)null, var8);
      } finally {
         this.field1092 = false;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)[B",
      garbageValue = "-460553467"
   )
   public static byte[] method1174(CharSequence var0) {
      int var1 = var0.length();
      byte[] var2 = new byte[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if(var4 > 0 && var4 < 128 || var4 >= 160 && var4 <= 255) {
            var2[var3] = (byte)var4;
         } else if(var4 == 8364) {
            var2[var3] = -128;
         } else if(var4 == 8218) {
            var2[var3] = -126;
         } else if(var4 == 402) {
            var2[var3] = -125;
         } else if(var4 == 8222) {
            var2[var3] = -124;
         } else if(var4 == 8230) {
            var2[var3] = -123;
         } else if(var4 == 8224) {
            var2[var3] = -122;
         } else if(var4 == 8225) {
            var2[var3] = -121;
         } else if(var4 == 710) {
            var2[var3] = -120;
         } else if(var4 == 8240) {
            var2[var3] = -119;
         } else if(var4 == 352) {
            var2[var3] = -118;
         } else if(var4 == 8249) {
            var2[var3] = -117;
         } else if(var4 == 338) {
            var2[var3] = -116;
         } else if(var4 == 381) {
            var2[var3] = -114;
         } else if(var4 == 8216) {
            var2[var3] = -111;
         } else if(var4 == 8217) {
            var2[var3] = -110;
         } else if(var4 == 8220) {
            var2[var3] = -109;
         } else if(var4 == 8221) {
            var2[var3] = -108;
         } else if(var4 == 8226) {
            var2[var3] = -107;
         } else if(var4 == 8211) {
            var2[var3] = -106;
         } else if(var4 == 8212) {
            var2[var3] = -105;
         } else if(var4 == 732) {
            var2[var3] = -104;
         } else if(var4 == 8482) {
            var2[var3] = -103;
         } else if(var4 == 353) {
            var2[var3] = -102;
         } else if(var4 == 8250) {
            var2[var3] = -101;
         } else if(var4 == 339) {
            var2[var3] = -100;
         } else if(var4 == 382) {
            var2[var3] = -98;
         } else if(var4 == 376) {
            var2[var3] = -97;
         } else {
            var2[var3] = 63;
         }
      }

      return var2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lclass182;III)Z",
      garbageValue = "2100209836"
   )
   static boolean method1175(class182 var0, int var1, int var2) {
      byte[] var3 = var0.getConfigData(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         class47.method890(var3);
         return true;
      }
   }
}
