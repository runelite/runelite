import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("e")
final class class2 implements class0 {
   @ObfuscatedName("z")
   @Export("osName")
   public static String osName;
   @ObfuscatedName("gl")
   @ObfuscatedSignature(
      signature = "[Ljz;"
   )
   static IndexedSprite[] field16;

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lit;Lit;ZI)V",
      garbageValue = "-678570190"
   )
   public static void method9(IndexDataBase var0, IndexDataBase var1, boolean var2) {
      ObjectComposition.objects_ref = var0;
      ObjectComposition.field3446 = var1;
      ObjectComposition.field3481 = var2;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(ZZB)Ljz;",
      garbageValue = "30"
   )
   static IndexedSprite method8(boolean var0, boolean var1) {
      return var0?(var1?class37.field527:class90.field1415):(var1?class29.field431:TextureProvider.field1758);
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(IIB)V",
      garbageValue = "93"
   )
   public static void method7(int var0, int var1) {
      Varbit var3 = (Varbit)Varbit.varbits.get((long)var0);
      Varbit var2;
      if(var3 != null) {
         var2 = var3;
      } else {
         byte[] var8 = Varbit.varbit_ref.getConfigData(14, var0);
         var3 = new Varbit();
         if(var8 != null) {
            var3.decode(new Buffer(var8));
         }

         Varbit.varbits.put(var3, (long)var0);
         var2 = var3;
      }

      int var4 = var2.configId;
      int var5 = var2.leastSignificantBit;
      int var6 = var2.mostSignificantBit;
      int var7 = class211.field2619[var6 - var5];
      if(var1 < 0 || var1 > var7) {
         var1 = 0;
      }

      var7 <<= var5;
      class211.widgetSettings[var4] = class211.widgetSettings[var4] & ~var7 | var1 << var5 & var7;
   }

   @ObfuscatedName("gh")
   @ObfuscatedSignature(
      signature = "(Lbw;IIS)V",
      garbageValue = "255"
   )
   static void method5(Player var0, int var1, int var2) {
      if(var0.animation == var1 && var1 != -1) {
         int var3 = class204.getAnimation(var1).replyMode;
         if(var3 == 1) {
            var0.actionFrame = 0;
            var0.field1207 = 0;
            var0.actionAnimationDisable = var2;
            var0.field1243 = 0;
         }

         if(var3 == 2) {
            var0.field1243 = 0;
         }
      } else if(var1 == -1 || var0.animation == -1 || class204.getAnimation(var1).forcedPriority >= class204.getAnimation(var0.animation).forcedPriority) {
         var0.animation = var1;
         var0.actionFrame = 0;
         var0.field1207 = 0;
         var0.actionAnimationDisable = var2;
         var0.field1243 = 0;
         var0.field1241 = var0.queueSize;
      }

   }

   @ObfuscatedName("jn")
   @ObfuscatedSignature(
      signature = "(Lhj;III)V",
      garbageValue = "1321677666"
   )
   static final void method4(Widget var0, int var1, int var2) {
      if(Client.field1052 == null && !Client.isMenuOpen) {
         if(var0 != null && DynamicObject.method1931(var0) != null) {
            Client.field1052 = var0;
            Widget var4 = class223.method4190(var0);
            if(var4 == null) {
               var4 = var0.dragParent;
            }

            Client.field1047 = var4;
            Client.field1088 = var1;
            Client.field1089 = var2;
            Timer.field2268 = 0;
            Client.field1159 = false;
            int var6 = Client.menuOptionCount - 1;
            if(var6 != -1) {
               ScriptVarType.field239 = new class87();
               ScriptVarType.field239.field1392 = Client.menuActionParams0[var6];
               ScriptVarType.field239.field1391 = Client.menuActionParams1[var6];
               ScriptVarType.field239.field1390 = Client.menuTypes[var6];
               ScriptVarType.field239.field1393 = Client.menuIdentifiers[var6];
               ScriptVarType.field239.field1394 = Client.menuOptions[var6];
            }

         }
      }
   }

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1858449218"
   )
   static final void method6() {
      int[] var0 = class94.field1480;

      int var1;
      for(var1 = 0; var1 < class94.playerIndexesCount; ++var1) {
         Player var2 = Client.cachedPlayers[var0[var1]];
         if(var2 != null && var2.field1223 > 0) {
            --var2.field1223;
            if(var2.field1223 == 0) {
               var2.overhead = null;
            }
         }
      }

      for(var1 = 0; var1 < Client.npcIndexesCount; ++var1) {
         int var4 = Client.npcIndices[var1];
         NPC var3 = Client.cachedNPCs[var4];
         if(var3 != null && var3.field1223 > 0) {
            --var3.field1223;
            if(var3.field1223 == 0) {
               var3.overhead = null;
            }
         }
      }

   }
}
