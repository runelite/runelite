import java.io.File;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("hf")
public class class212 {
   @ObfuscatedName("i")
   public static int[] field2607;
   @ObfuscatedName("j")
   @Export("settings")
   public static int[] settings;
   @ObfuscatedName("a")
   @Export("widgetSettings")
   public static int[] widgetSettings;
   @ObfuscatedName("r")
   public static File field2609;

   static {
      field2607 = new int[32];
      int var0 = 2;

      for(int var1 = 0; var1 < 32; ++var1) {
         field2607[var1] = var0 - 1;
         var0 += var0;
      }

      settings = new int[2000];
      widgetSettings = new int[2000];
   }

   @ObfuscatedName("hi")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1604837160"
   )
   static final void method3969() {
      boolean var0 = false;

      while(!var0) {
         var0 = true;

         for(int var1 = 0; var1 < Client.menuOptionCount - 1; ++var1) {
            if(Client.menuTypes[var1] < 1000 && Client.menuTypes[var1 + 1] > 1000) {
               String var2 = Client.menuTargets[var1];
               Client.menuTargets[var1] = Client.menuTargets[var1 + 1];
               Client.menuTargets[var1 + 1] = var2;
               String var3 = Client.menuOptions[var1];
               Client.menuOptions[var1] = Client.menuOptions[var1 + 1];
               Client.menuOptions[var1 + 1] = var3;
               int var4 = Client.menuTypes[var1];
               Client.menuTypes[var1] = Client.menuTypes[var1 + 1];
               Client.menuTypes[var1 + 1] = var4;
               var4 = Client.menuActionParams0[var1];
               Client.menuActionParams0[var1] = Client.menuActionParams0[var1 + 1];
               Client.menuActionParams0[var1 + 1] = var4;
               var4 = Client.menuActionParams1[var1];
               Client.menuActionParams1[var1] = Client.menuActionParams1[var1 + 1];
               Client.menuActionParams1[var1 + 1] = var4;
               var4 = Client.menuIdentifiers[var1];
               Client.menuIdentifiers[var1] = Client.menuIdentifiers[var1 + 1];
               Client.menuIdentifiers[var1 + 1] = var4;
               boolean var5 = Client.field1077[var1];
               Client.field1077[var1] = Client.field1077[var1 + 1];
               Client.field1077[var1 + 1] = var5;
               var0 = false;
            }
         }
      }

   }
}
