import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cr")
public class class99 {
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 1720773869
   )
   static int field1515;
   @ObfuscatedName("e")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "Lgw;"
   )
   static final IterableHashTable field1516;
   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "Lgj;"
   )
   static final class202 field1520;

   static {
      chatLineMap = new HashMap();
      field1516 = new IterableHashTable(1024);
      field1520 = new class202();
      field1515 = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(IB)V",
      garbageValue = "-49"
   )
   public static void method1881(int var0) {
      if(var0 != -1) {
         if(Timer.validInterfaces[var0]) {
            Widget.widgetIndex.method4159(var0);
            if(Item.widgets[var0] != null) {
               boolean var1 = true;

               for(int var2 = 0; var2 < Item.widgets[var0].length; ++var2) {
                  if(Item.widgets[var0][var2] != null) {
                     if(Item.widgets[var0][var2].type != 2) {
                        Item.widgets[var0][var2] = null;
                     } else {
                        var1 = false;
                     }
                  }
               }

               if(var1) {
                  Item.widgets[var0] = null;
               }

               Timer.validInterfaces[var0] = false;
            }
         }
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "([Ljava/lang/String;[SIII)V",
      garbageValue = "429710192"
   )
   static void method1880(String[] var0, short[] var1, int var2, int var3) {
      if(var2 < var3) {
         int var4 = (var3 + var2) / 2;
         int var5 = var2;
         String var6 = var0[var4];
         var0[var4] = var0[var3];
         var0[var3] = var6;
         short var7 = var1[var4];
         var1[var4] = var1[var3];
         var1[var3] = var7;

         for(int var8 = var2; var8 < var3; ++var8) {
            if(var6 == null || var0[var8] != null && var0[var8].compareTo(var6) < (var8 & 1)) {
               String var9 = var0[var8];
               var0[var8] = var0[var5];
               var0[var5] = var9;
               short var10 = var1[var8];
               var1[var8] = var1[var5];
               var1[var5++] = var10;
            }
         }

         var0[var3] = var0[var5];
         var0[var5] = var6;
         var1[var3] = var1[var5];
         var1[var5] = var7;
         method1880(var0, var1, var2, var5 - 1);
         method1880(var0, var1, var5 + 1, var3);
      }

   }
}
