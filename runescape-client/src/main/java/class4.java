import java.math.BigInteger;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("n")
public class class4 {
   @ObfuscatedName("qe")
   @ObfuscatedGetter(
      intValue = -890938571
   )
   static int field73;
   @ObfuscatedName("dx")
   static byte[][] field76;
   @ObfuscatedName("h")
   static final BigInteger field77 = new BigInteger("ae2445eceaada0dace263d69bf496cfb913f7abd2dd9cf9971250271c6dcb435f1dd0cc66187179d293636f349ede5685034cae7f2151c21d8ab56cea05099446d37c177f9c0d9a51a27f43c1990e4e76b0ca86cb0f5fa92003c5be6c36d873a284a2caf0f11b31c0902d95078e3a2d04104803ffaf2a0bf3f2e2c894c09c00d", 16);
   @ObfuscatedName("r")
   static String field79;
   @ObfuscatedName("ao")
   static boolean field81;
   @ObfuscatedName("i")
   static final BigInteger field83 = new BigInteger("10001", 16);

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(Lclass125;I)V",
      garbageValue = "-678138651"
   )
   static final void method52(class125 var0) {
      var0.method2786();
      int var1 = Client.localInteractingIndex;
      Player var2 = class138.localPlayer = Client.cachedPlayers[var1] = new Player();
      var2.field54 = var1;
      int var3 = var0.method2787(30);
      byte var4 = (byte)(var3 >> 28);
      int var5 = var3 >> 14 & 16383;
      int var6 = var3 & 16383;
      var2.pathX[0] = var5 - class193.baseX;
      var2.x = (var2.pathX[0] << 7) + (var2.method16() << 6);
      var2.pathY[0] = var6 - DecorativeObject.baseY;
      var2.y = (var2.pathY[0] << 7) + (var2.method16() << 6);
      class173.plane = var2.field53 = var4;
      if(class34.field784[var1] != null) {
         var2.method15(class34.field784[var1]);
      }

      class34.field779 = 0;
      class34.field786[++class34.field779 - 1] = var1;
      class34.field785[var1] = 0;
      class34.field776 = 0;

      for(int var7 = 1; var7 < 2048; ++var7) {
         if(var1 != var7) {
            int var8 = var0.method2787(18);
            int var9 = var8 >> 16;
            int var10 = var8 >> 8 & 255;
            int var11 = var8 & 255;
            class34.field783[var7] = (var9 << 28) + (var10 << 14) + var11;
            class34.field780[var7] = 0;
            class34.field788[var7] = -1;
            class34.field782[++class34.field776 - 1] = var7;
            class34.field785[var7] = 0;
         }
      }

      var0.method2790();
   }

   @ObfuscatedName("by")
   @ObfuscatedSignature(
      signature = "(IIIIIIIIII)V",
      garbageValue = "-93989849"
   )
   static final void method53(int var0, int var1, int var2, int var3, int var4, int var5, int var6, int var7, int var8) {
      class16 var9 = null;

      for(class16 var10 = (class16)Client.field571.method3845(); null != var10; var10 = (class16)Client.field571.method3847()) {
         if(var10.field252 == var0 && var1 == var10.field243 && var10.field260 == var2 && var10.field246 == var3) {
            var9 = var10;
            break;
         }
      }

      if(null == var9) {
         var9 = new class16();
         var9.field252 = var0;
         var9.field246 = var3;
         var9.field243 = var1;
         var9.field260 = var2;
         class14.method171(var9);
         Client.field571.method3865(var9);
      }

      var9.field248 = var4;
      var9.field250 = var5;
      var9.field249 = var6;
      var9.field244 = var7;
      var9.field242 = var8;
   }

   @ObfuscatedName("dx")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "-1526816536"
   )
   static final void method54(String var0) {
      if(null != var0) {
         String var1 = class93.method2141(var0, Client.field302);
         if(null != var1) {
            for(int var2 = 0; var2 < Client.ignoreCount; ++var2) {
               Ignore var3 = Client.ignores[var2];
               String var4 = var3.name;
               String var5 = class93.method2141(var4, Client.field302);
               if(Sequence.method920(var0, var1, var4, var5)) {
                  --Client.ignoreCount;

                  for(int var6 = var2; var6 < Client.ignoreCount; ++var6) {
                     Client.ignores[var6] = Client.ignores[1 + var6];
                  }

                  Client.field493 = Client.field485;
                  Client.field378.method2801(37);
                  Client.field378.method2529(class21.method547(var0));
                  Client.field378.method2535(var0);
                  break;
               }
            }

         }
      }
   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "769472547"
   )
   public static void method55() {
      if(null != class143.mouse) {
         class143 var0 = class143.mouse;
         synchronized(class143.mouse) {
            class143.mouse = null;
         }
      }

   }

   @ObfuscatedName("ac")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1629141563"
   )
   static final void method56(boolean var0) {
      for(int var1 = 0; var1 < Client.field341; ++var1) {
         NPC var2 = Client.cachedNPCs[Client.field342[var1]];
         int var3 = 536870912 + (Client.field342[var1] << 14);
         if(var2 != null && var2.vmethod783() && var0 == var2.composition.isVisible && var2.composition.method832()) {
            int var4 = var2.x >> 7;
            int var5 = var2.y >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field839 == 1 && (var2.x & 127) == 64 && (var2.y & 127) == 64) {
                  if(Client.field406[var4][var5] == Client.field407) {
                     continue;
                  }

                  Client.field406[var4][var5] = Client.field407;
               }

               if(!var2.composition.field937) {
                  var3 -= Integer.MIN_VALUE;
               }

               class128.region.method1963(class173.plane, var2.x, var2.y, class16.method191(var2.field839 * 64 - 64 + var2.x, var2.y + (var2.field839 * 64 - 64), class173.plane), 60 + (var2.field839 * 64 - 64), var2, var2.angle, var3, var2.field838);
            }
         }
      }

   }
}
