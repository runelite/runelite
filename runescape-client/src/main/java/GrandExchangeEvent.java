import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringReader;
import java.io.StringWriter;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("s")
@Implements("GrandExchangeEvent")
public class GrandExchangeEvent {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 53282199
   )
   static int field274;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 888684457
   )
   @Export("world")
   public final int world;
   @ObfuscatedName("q")
   @ObfuscatedGetter(
      longValue = -2104138748474239123L
   )
   public final long field269;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lf;"
   )
   @Export("grandExchangeOffer")
   public final GrandExchangeOffer grandExchangeOffer;
   @ObfuscatedName("p")
   @Export("string1")
   String string1;
   @ObfuscatedName("a")
   @Export("string2")
   String string2;

   @ObfuscatedSignature(
      signature = "(Lgn;BI)V"
   )
   GrandExchangeEvent(Buffer var1, byte var2, int var3) {
      this.string1 = var1.readString();
      this.string2 = var1.readString();
      this.world = var1.readUnsignedShort();
      this.field269 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.grandExchangeOffer = new GrandExchangeOffer();
      this.grandExchangeOffer.method105(2);
      this.grandExchangeOffer.method106(var2);
      this.grandExchangeOffer.price = var4;
      this.grandExchangeOffer.totalQuantity = var5;
      this.grandExchangeOffer.quantitySold = 0;
      this.grandExchangeOffer.spent = 0;
      this.grandExchangeOffer.itemId = var3;
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "104"
   )
   public String method76() {
      return this.string1;
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1614133997"
   )
   public String method83() {
      return this.string2;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/Throwable;B)Ljava/lang/String;",
      garbageValue = "-10"
   )
   static String method86(Throwable var0) throws IOException {
      String var1;
      if(var0 instanceof RunException) {
         RunException var2 = (RunException)var0;
         var1 = var2.field2146 + " | ";
         var0 = var2.field2143;
      } else {
         var1 = "";
      }

      StringWriter var12 = new StringWriter();
      PrintWriter var3 = new PrintWriter(var12);
      var0.printStackTrace(var3);
      var3.close();
      String var4 = var12.toString();
      BufferedReader var5 = new BufferedReader(new StringReader(var4));
      String var6 = var5.readLine();

      while(true) {
         while(true) {
            String var7 = var5.readLine();
            if(var7 == null) {
               var1 = var1 + "| " + var6;
               return var1;
            }

            int var8 = var7.indexOf(40);
            int var9 = var7.indexOf(41, var8 + 1);
            if(var8 >= 0 && var9 >= 0) {
               String var10 = var7.substring(var8 + 1, var9);
               int var11 = var10.indexOf(".java:");
               if(var11 >= 0) {
                  var10 = var10.substring(0, var11) + var10.substring(var11 + 5);
                  var1 = var1 + var10 + ' ';
                  continue;
               }

               var7 = var7.substring(0, var8);
            }

            var7 = var7.trim();
            var7 = var7.substring(var7.lastIndexOf(32) + 1);
            var7 = var7.substring(var7.lastIndexOf(9) + 1);
            var1 = var1 + var7 + ' ';
         }
      }
   }

   @ObfuscatedName("ft")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-894442166"
   )
   static final void method82(boolean var0) {
      if(var0) {
         Client.field856 = class89.field1312?class157.field2115:class157.field2113;
      } else {
         Client.field856 = Client.preferences.preferences.containsKey(Integer.valueOf(class240.method4493(class89.username)))?class157.field2117:class157.field2119;
      }

   }
}
