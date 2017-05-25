import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
public class class20 {
   @ObfuscatedName("ib")
   static Widget field323;
   @ObfuscatedName("ct")
   @Export("indexTextures")
   static IndexData indexTextures;
   @ObfuscatedName("dy")
   @ObfuscatedGetter(
      longValue = 6723910401772645213L
   )
   static long field329;
   @ObfuscatedName("mp")
   static class156 field331;

   @ObfuscatedName("gc")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "1505697663"
   )
   static final void method146(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class76 var9 = null;

      for(class76 var10 = (class76)Client.field1021.method3660(); var10 != null; var10 = (class76)Client.field1021.method3661()) {
         if(var0 == var10.field1174 && var10.field1176 == var1 && var10.field1177 == var2 && var10.field1181 == var3) {
            var9 = var10;
            break;
         }
      }

      if(var9 == null) {
         var9 = new class76();
         var9.field1174 = var0;
         var9.field1181 = var3;
         var9.field1176 = var1;
         var9.field1177 = var2;
         class69.method1115(var9);
         Client.field1021.method3655(var9);
      }

      var9.field1175 = var4;
      var9.field1183 = var5;
      var9.field1182 = var6;
      var9.field1184 = var7;
      var9.field1185 = var8;
   }

   @ObfuscatedName("fy")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1073345712"
   )
   static final void method147() {
      int var0 = class96.field1489;
      int[] var1 = class96.field1496;

      for(int var2 = 0; var2 < var0; ++var2) {
         Player var3 = Client.cachedPlayers[var1[var2]];
         if(var3 != null) {
            class21.method149(var3, 1);
         }
      }

   }

   @ObfuscatedName("v")
   @ObfuscatedSignature(
      signature = "(I)Z",
      garbageValue = "2093786270"
   )
   public static boolean method148() {
      return class203.field2498 != 0?true:class36.field501.method3825();
   }
}
