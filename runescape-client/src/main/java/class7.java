import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("g")
public class class7 {
   @ObfuscatedName("d")
   public static boolean field243;
   @ObfuscatedName("k")
   public static boolean field242;
   @ObfuscatedName("e")
   public static boolean field245;
   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "Lo;"
   )
   public static class11 field244;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lgp;"
   )
   public static CombatInfoList field247;

   static {
      field243 = false;
      field242 = false;
      field245 = false;
      field244 = class11.field272;
      field247 = new CombatInfoList();
   }

   @ObfuscatedName("ie")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1514878070"
   )
   static final void method41() {
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
               boolean var5 = Client.field1021[var1];
               Client.field1021[var1] = Client.field1021[var1 + 1];
               Client.field1021[var1 + 1] = var5;
               var0 = false;
            }
         }
      }

   }

   @ObfuscatedName("gu")
   @ObfuscatedSignature(
      signature = "(Lbw;ZI)V",
      garbageValue = "1646322556"
   )
   static void method35(Player var0, boolean var1) {
      if(var0 != null && var0.hasConfig() && !var0.hidden) {
         int var2 = var0.field886 << 14;
         var0.field901 = false;
         if((Client.lowMemory && class94.field1485 > 50 || class94.field1485 > 200) && var1 && var0.poseAnimation == var0.idlePoseAnimation) {
            var0.field901 = true;
         }

         int var3 = var0.x >> 7;
         int var4 = var0.y >> 7;
         if(var3 >= 0 && var3 < 104 && var4 >= 0 && var4 < 104) {
            if(var0.model != null && Client.gameCycle >= var0.field891 && Client.gameCycle < var0.field892) {
               var0.field901 = false;
               var0.field890 = CacheFile.getTileHeight(var0.x, var0.y, class5.plane);
               class8.region.method2811(class5.plane, var0.x, var0.y, var0.field890, 60, var0, var0.angle, var2, var0.field904, var0.field898, var0.field883, var0.field900);
            } else {
               if((var0.x & 127) == 64 && (var0.y & 127) == 64) {
                  if(Client.field1015[var3][var4] == Client.field1016) {
                     return;
                  }

                  Client.field1015[var3][var4] = Client.field1016;
               }

               var0.field890 = CacheFile.getTileHeight(var0.x, var0.y, class5.plane);
               class8.region.method2768(class5.plane, var0.x, var0.y, var0.field890, 60, var0, var0.angle, var2, var0.field1210);
            }
         }
      }

   }

   @ObfuscatedName("kw")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;ZI)V",
      garbageValue = "117519009"
   )
   static void method42(String var0, boolean var1) {
      var0 = var0.toLowerCase();
      short[] var2 = new short[16];
      int var3 = 0;

      for(int var4 = 0; var4 < class226.field3144; ++var4) {
         ItemComposition var5 = class46.getItemDefinition(var4);
         if((!var1 || var5.field3538) && var5.notedTemplate == -1 && var5.name.toLowerCase().indexOf(var0) != -1) {
            if(var3 >= 250) {
               class25.field370 = -1;
               class33.field491 = null;
               return;
            }

            if(var3 >= var2.length) {
               short[] var6 = new short[var2.length * 2];

               for(int var7 = 0; var7 < var3; ++var7) {
                  var6[var7] = var2[var7];
               }

               var2 = var6;
            }

            var2[var3++] = (short)var4;
         }
      }

      class33.field491 = var2;
      ScriptVarType.field101 = 0;
      class25.field370 = var3;
      String[] var8 = new String[class25.field370];

      for(int var9 = 0; var9 < class25.field370; ++var9) {
         var8[var9] = class46.getItemDefinition(var2[var9]).name;
      }

      Frames.method2948(var8, class33.field491);
   }
}
