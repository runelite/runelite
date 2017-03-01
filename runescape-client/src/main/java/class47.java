import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ai")
public class class47 {
   @ObfuscatedName("n")
   static final class121 field943 = new class121(1024);
   @ObfuscatedName("g")
   static final class136 field944 = new class136();
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 704168519
   )
   static int field945 = 0;
   @ObfuscatedName("ab")
   static int[] field946;
   @ObfuscatedName("aw")
   static class110 field947;
   @ObfuscatedName("kw")
   static class112 field948;
   @ObfuscatedName("x")
   @Export("chatLineMap")
   static final Map chatLineMap = new HashMap();

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "69"
   )
   static int method960(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      if(var0 == 3200) {
         class32.field735 -= 3;
         var3 = class32.field726[class32.field735];
         var4 = class32.field726[1 + class32.field735];
         int var5 = class32.field726[class32.field735 + 2];
         if(Client.field530 != 0 && var4 != 0 && Client.field532 < 50) {
            Client.field533[Client.field532] = var3;
            Client.field534[Client.field532] = var4;
            Client.field535[Client.field532] = var5;
            Client.field537[Client.field532] = null;
            Client.field536[Client.field532] = 0;
            ++Client.field532;
         }

         return 1;
      } else if(var0 == 3201) {
         class161.method3178(class32.field726[--class32.field735]);
         return 1;
      } else if(var0 == 3202) {
         class32.field735 -= 2;
         var3 = class32.field726[class32.field735];
         var4 = class32.field726[class32.field735 + 1];
         if(Client.field544 != 0 && var3 != -1) {
            class44.method892(WidgetNode.field175, var3, 0, Client.field544, false);
            Client.field439 = true;
         }

         return 1;
      } else {
         return 2;
      }
   }

   class47() throws Throwable {
      throw new Error();
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(Lclass68;I)V",
      garbageValue = "1315688335"
   )
   static final void method968(class68 var0) {
      var0.field1156 = false;
      if(var0.field1159 != null) {
         var0.field1159.field1190 = 0;
      }

      for(class68 var1 = var0.vmethod2765(); null != var1; var1 = var0.vmethod2775()) {
         method968(var1);
      }

   }

   @ObfuscatedName("x")
   public static final void method970(long var0) {
      if(var0 > 0L) {
         if(0L == var0 % 10L) {
            long var2 = var0 - 1L;

            try {
               Thread.sleep(var2);
            } catch (InterruptedException var8) {
               ;
            }

            try {
               Thread.sleep(1L);
            } catch (InterruptedException var7) {
               ;
            }
         } else {
            try {
               Thread.sleep(var0);
            } catch (InterruptedException var6) {
               ;
            }
         }

      }
   }
}
