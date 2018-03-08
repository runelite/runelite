import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("u")
@Implements("GrandExchangeEvent")
public class GrandExchangeEvent {
   @ObfuscatedName("do")
   @Export("host")
   static String host;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1042997751
   )
   @Export("world")
   public final int world;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = 6025418101370467541L
   )
   public final long field274;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lk;"
   )
   @Export("grandExchangeOffer")
   public final GrandExchangeOffer grandExchangeOffer;
   @ObfuscatedName("a")
   @Export("string1")
   String string1;
   @ObfuscatedName("l")
   @Export("string2")
   String string2;

   @ObfuscatedSignature(
      signature = "(Lgb;BI)V"
   )
   GrandExchangeEvent(Buffer var1, byte var2, int var3) {
      this.string1 = var1.readString();
      this.string2 = var1.readString();
      this.world = var1.readUnsignedShort();
      this.field274 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.grandExchangeOffer = new GrandExchangeOffer();
      this.grandExchangeOffer.method106(2);
      this.grandExchangeOffer.method107(var2);
      this.grandExchangeOffer.price = var4;
      this.grandExchangeOffer.totalQuantity = var5;
      this.grandExchangeOffer.quantitySold = 0;
      this.grandExchangeOffer.spent = 0;
      this.grandExchangeOffer.itemId = var3;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "14"
   )
   public String method82() {
      return this.string1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1505801552"
   )
   public String method84() {
      return this.string2;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;B)J",
      garbageValue = "1"
   )
   public static long method91(CharSequence var0) {
      long var1 = 0L;
      int var3 = var0.length();

      for(int var4 = 0; var4 < var3; ++var4) {
         var1 *= 37L;
         char var5 = var0.charAt(var4);
         if(var5 >= 'A' && var5 <= 'Z') {
            var1 += (long)(var5 + 1 - 65);
         } else if(var5 >= 'a' && var5 <= 'z') {
            var1 += (long)(var5 + 1 - 97);
         } else if(var5 >= '0' && var5 <= '9') {
            var1 += (long)(var5 + 27 - 48);
         }

         if(var1 >= 177917621779460413L) {
            break;
         }
      }

      while(0L == var1 % 37L && var1 != 0L) {
         var1 /= 37L;
      }

      return var1;
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ILcj;ZI)I",
      garbageValue = "482146849"
   )
   static int method88(int var0, Script var1, boolean var2) {
      Widget var3 = var2?class233.field2755:class81.field1260;
      if(var0 == 1800) {
         int[] var4 = class81.intStack;
         int var5 = ++class5.intStackSize - 1;
         int var7 = getWidgetConfig(var3);
         int var6 = var7 >> 11 & 63;
         var4[var5] = var6;
         return 1;
      } else if(var0 != 1801) {
         if(var0 == 1802) {
            if(var3.name == null) {
               class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
            } else {
               class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var3.name;
            }

            return 1;
         } else {
            return 2;
         }
      } else {
         int var8 = class81.intStack[--class5.intStackSize];
         --var8;
         if(var3.actions != null && var8 < var3.actions.length && var3.actions[var8] != null) {
            class81.scriptStringStack[++class316.scriptStringStackSize - 1] = var3.actions[var8];
         } else {
            class81.scriptStringStack[++class316.scriptStringStackSize - 1] = "";
         }

         return 1;
      }
   }

   @ObfuscatedName("jr")
   @ObfuscatedSignature(
      signature = "(Lig;I)I",
      garbageValue = "400254367"
   )
   @Export("getWidgetConfig")
   static int getWidgetConfig(Widget var0) {
      IntegerNode var1 = (IntegerNode)Client.widgetFlags.get((long)var0.index + ((long)var0.id << 32));
      return var1 != null?var1.value:var0.config;
   }
}
