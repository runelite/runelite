import java.io.IOException;
import java.util.Comparator;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("f")
final class class22 implements Comparator {
   @ObfuscatedName("fv")
   @ObfuscatedGetter(
      intValue = -551291999
   )
   @Export("cameraPitch")
   static int cameraPitch;
   // $FF: synthetic field
   final boolean val$preferOwnWorld;

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "199195114"
   )
   public static void method549() {
      try {
         if(class186.field3010 == 1) {
            int var0 = class186.field3013.method3626();
            if(var0 > 0 && class186.field3013.method3631()) {
               var0 -= class54.field1154;
               if(var0 < 0) {
                  var0 = 0;
               }

               class186.field3013.method3625(var0);
               return;
            }

            class186.field3013.method3725();
            class186.field3013.method3661();
            if(class35.field800 != null) {
               class186.field3010 = 2;
            } else {
               class186.field3010 = 0;
            }

            class52.field1143 = null;
            class14.field219 = null;
         }
      } catch (Exception var2) {
         var2.printStackTrace();
         class186.field3013.method3725();
         class186.field3010 = 0;
         class52.field1143 = null;
         class14.field219 = null;
         class35.field800 = null;
      }

   }

   public int compare(Object var1, Object var2) {
      return this.method560((class217)var1, (class217)var2);
   }

   class22(boolean var1) {
      this.val$preferOwnWorld = var1;
   }

   @ObfuscatedName("at")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "20"
   )
   static final void method556(boolean var0) {
      class212.method3957();
      ++Client.field480;
      if(Client.field480 >= 50 || var0) {
         Client.field480 = 0;
         if(!Client.field356 && null != ObjectComposition.field993) {
            Client.field378.method2801(210);

            try {
               ObjectComposition.field993.method3028(Client.field378.payload, 0, Client.field378.offset);
               Client.field378.offset = 0;
            } catch (IOException var2) {
               Client.field356 = true;
            }
         }

      }
   }

   public boolean equals(Object var1) {
      return super.equals(var1);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(Lclass170;III)Z",
      garbageValue = "551177578"
   )
   public static boolean method559(class170 var0, int var1, int var2) {
      byte[] var3 = var0.method3292(var1, var2);
      if(var3 == null) {
         return false;
      } else {
         NPC.method760(var3);
         return true;
      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass217;Lclass217;I)I",
      garbageValue = "763650810"
   )
   int method560(class217 var1, class217 var2) {
      if(var2.field3204 == var1.field3204) {
         return 0;
      } else {
         if(this.val$preferOwnWorld) {
            if(var1.field3204 == Client.world) {
               return -1;
            }

            if(var2.field3204 == Client.world) {
               return 1;
            }
         }

         return var1.field3204 < var2.field3204?-1:1;
      }
   }
}
