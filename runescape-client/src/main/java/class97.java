import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("co")
@Implements("DecorativeObject")
public final class class97 {
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = 806069171
   )
   int field1670;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = -147816977
   )
   @Export("x")
   int field1671;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1593855433
   )
   @Export("y")
   int field1672;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1153348231
   )
   int field1673;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 557614157
   )
   @Export("floor")
   int field1674;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = -1700868317
   )
   int field1676;
   @ObfuscatedName("u")
   @Export("renderable1")
   public class88 field1677;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 2080960447
   )
   int field1678;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 473455513
   )
   @Export("hash")
   public int field1679 = 0;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1434174201
   )
   int field1680 = 0;
   @ObfuscatedName("o")
   @Export("renderable2")
   public class88 field1683;

   @ObfuscatedName("aj")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-375886135"
   )
   static final void method2261(boolean var0) {
      for(int var1 = 0; var1 < client.field332; ++var1) {
         class36 var2 = client.field331[client.field333[var1]];
         int var3 = (client.field333[var1] << 14) + 536870912;
         if(null != var2 && var2.vmethod787() && var0 == var2.field825.field921 && var2.field825.method813()) {
            int var4 = var2.field896 >> 7;
            int var5 = var2.field879 >> 7;
            if(var4 >= 0 && var4 < 104 && var5 >= 0 && var5 < 104) {
               if(var2.field851 == 1 && (var2.field896 & 127) == 64 && (var2.field879 & 127) == 64) {
                  if(client.field311[var4][var5] == client.field400) {
                     continue;
                  }

                  client.field311[var4][var5] = client.field400;
               }

               if(!var2.field825.field947) {
                  var3 -= Integer.MIN_VALUE;
               }

               class79.field1453.method2020(class50.field1119, var2.field896, var2.field879, class105.method2370(var2.field896 + (var2.field851 * 64 - 64), var2.field879 + (var2.field851 * 64 - 64), class50.field1119), var2.field851 * 64 - 64 + 60, var2, var2.field905, var3, var2.field853);
            }
         }
      }

   }

   @ObfuscatedName("be")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "548797885"
   )
   static final void method2262() {
      client.field338.method2878();
      int var0 = client.field338.method2859(8);
      int var1;
      if(var0 < client.field332) {
         for(var1 = var0; var1 < client.field332; ++var1) {
            client.field315[++client.field419 - 1] = client.field333[var1];
         }
      }

      if(var0 > client.field332) {
         throw new RuntimeException("");
      } else {
         client.field332 = 0;

         for(var1 = 0; var1 < var0; ++var1) {
            int var2 = client.field333[var1];
            class36 var3 = client.field331[var2];
            int var4 = client.field338.method2859(1);
            if(var4 == 0) {
               client.field333[++client.field332 - 1] = var2;
               var3.field899 = client.field567;
            } else {
               int var5 = client.field338.method2859(2);
               if(var5 == 0) {
                  client.field333[++client.field332 - 1] = var2;
                  var3.field899 = client.field567;
                  client.field335[++client.field334 - 1] = var2;
               } else {
                  int var6;
                  int var7;
                  if(var5 == 1) {
                     client.field333[++client.field332 - 1] = var2;
                     var3.field899 = client.field567;
                     var6 = client.field338.method2859(3);
                     var3.method751(var6, (byte)1);
                     var7 = client.field338.method2859(1);
                     if(var7 == 1) {
                        client.field335[++client.field334 - 1] = var2;
                     }
                  } else if(var5 == 2) {
                     client.field333[++client.field332 - 1] = var2;
                     var3.field899 = client.field567;
                     var6 = client.field338.method2859(3);
                     var3.method751(var6, (byte)2);
                     var7 = client.field338.method2859(3);
                     var3.method751(var7, (byte)2);
                     int var8 = client.field338.method2859(1);
                     if(var8 == 1) {
                        client.field335[++client.field334 - 1] = var2;
                     }
                  } else if(var5 == 3) {
                     client.field315[++client.field419 - 1] = var2;
                  }
               }
            }
         }

      }
   }
}
