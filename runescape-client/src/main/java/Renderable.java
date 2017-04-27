import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cy")
@Implements("Renderable")
public abstract class Renderable extends CacheableNode {
   @ObfuscatedName("cs")
   @ObfuscatedGetter(
      intValue = -2096719255
   )
   @Export("modelHeight")
   public int modelHeight = 1000;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1263656229"
   )
   static void method1896() {
      FileOnDisk var0 = null;

      try {
         var0 = class59.getPreferencesFile("", class188.field2778.name, true);
         Buffer var1 = Actor.field656.method651();
         var0.method1424(var1.payload, 0, var1.offset);
      } catch (Exception var3) {
         ;
      }

      try {
         if(var0 != null) {
            var0.method1425();
         }
      } catch (Exception var2) {
         ;
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(B)LModel;",
      garbageValue = "-18"
   )
   @Export("getModel")
   protected Model getModel() {
      return null;
   }

   @ObfuscatedName("ct")
   void vmethod1902(int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8, int var9) {
      Model var10 = this.getModel();
      if(var10 != null) {
         this.modelHeight = var10.modelHeight;
         var10.vmethod1902(var1, var2, var3, var4, var5, var6, var7, var8, var9);
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "-1335158353"
   )
   static int method1903(int var0, Script var1, boolean var2) {
      if(var0 == 6200) {
         class32.field715 -= 2;
         Client.field500 = (short)class32.field720[class32.field715];
         if(Client.field500 <= 0) {
            Client.field500 = 256;
         }

         Client.field541 = (short)class32.field720[class32.field715 + 1];
         if(Client.field541 <= 0) {
            Client.field541 = 205;
         }

         return 1;
      } else if(var0 == 6201) {
         class32.field715 -= 2;
         Client.field542 = (short)class32.field720[class32.field715];
         if(Client.field542 <= 0) {
            Client.field542 = 256;
         }

         Client.field318 = (short)class32.field720[class32.field715 + 1];
         if(Client.field318 <= 0) {
            Client.field318 = 320;
         }

         return 1;
      } else if(var0 == 6202) {
         class32.field715 -= 4;
         Client.field509 = (short)class32.field720[class32.field715];
         if(Client.field509 <= 0) {
            Client.field509 = 1;
         }

         Client.field459 = (short)class32.field720[class32.field715 + 1];
         if(Client.field459 <= 0) {
            Client.field459 = 32767;
         } else if(Client.field459 < Client.field509) {
            Client.field459 = Client.field509;
         }

         Client.field320 = (short)class32.field720[class32.field715 + 2];
         if(Client.field320 <= 0) {
            Client.field320 = 1;
         }

         Client.field547 = (short)class32.field720[class32.field715 + 3];
         if(Client.field547 <= 0) {
            Client.field547 = 32767;
         } else if(Client.field547 < Client.field320) {
            Client.field547 = Client.field320;
         }

         return 1;
      } else if(var0 == 6203) {
         if(Client.field457 != null) {
            class173.method3257(0, 0, Client.field457.width, Client.field457.height, false);
            class32.field720[++class32.field715 - 1] = Client.camera2;
            class32.field720[++class32.field715 - 1] = Client.camera3;
         } else {
            class32.field720[++class32.field715 - 1] = -1;
            class32.field720[++class32.field715 - 1] = -1;
         }

         return 1;
      } else if(var0 == 6204) {
         class32.field720[++class32.field715 - 1] = Client.field542;
         class32.field720[++class32.field715 - 1] = Client.field318;
         return 1;
      } else if(var0 == 6205) {
         class32.field720[++class32.field715 - 1] = Client.field500;
         class32.field720[++class32.field715 - 1] = Client.field541;
         return 1;
      } else {
         return 2;
      }
   }
}
