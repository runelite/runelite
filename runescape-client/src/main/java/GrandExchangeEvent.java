import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("y")
@Implements("GrandExchangeEvent")
public class GrandExchangeEvent {
   @ObfuscatedName("ff")
   @ObfuscatedSignature(
      signature = "Lks;"
   )
   @Export("compass")
   static SpritePixels compass;
   @ObfuscatedName("gd")
   @ObfuscatedGetter(
      intValue = 508599443
   )
   @Export("cameraZ")
   static int cameraZ;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 306485541
   )
   @Export("world")
   public final int world;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = 8897992286683141835L
   )
   public final long field278;
   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "Lr;"
   )
   @Export("grandExchangeOffer")
   public final GrandExchangeOffer grandExchangeOffer;
   @ObfuscatedName("k")
   @Export("string1")
   String string1;
   @ObfuscatedName("u")
   @Export("string2")
   String string2;

   @ObfuscatedSignature(
      signature = "(Lgh;BI)V"
   )
   GrandExchangeEvent(Buffer var1, byte var2, int var3) {
      this.string1 = var1.readString();
      this.string2 = var1.readString();
      this.world = var1.readUnsignedShort();
      this.field278 = var1.readLong();
      int var4 = var1.readInt();
      int var5 = var1.readInt();
      this.grandExchangeOffer = new GrandExchangeOffer();
      this.grandExchangeOffer.method99(2);
      this.grandExchangeOffer.method95(var2);
      this.grandExchangeOffer.price = var4;
      this.grandExchangeOffer.totalQuantity = var5;
      this.grandExchangeOffer.quantitySold = 0;
      this.grandExchangeOffer.spent = 0;
      this.grandExchangeOffer.itemId = var3;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(I)Ljava/lang/String;",
      garbageValue = "-1856400372"
   )
   public String method72() {
      return this.string1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(B)Ljava/lang/String;",
      garbageValue = "0"
   )
   public String method78() {
      return this.string2;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;I)Ljava/lang/String;",
      garbageValue = "-1443270829"
   )
   public static String method84(CharSequence var0) {
      int var1 = var0.length();
      StringBuilder var2 = new StringBuilder(var1);

      for(int var3 = 0; var3 < var1; ++var3) {
         char var4 = var0.charAt(var3);
         if((var4 < 'a' || var4 > 'z') && (var4 < 'A' || var4 > 'Z') && (var4 < '0' || var4 > '9') && var4 != '.' && var4 != '-' && var4 != '*' && var4 != '_') {
            if(var4 == ' ') {
               var2.append('+');
            } else {
               byte var5 = class34.charToByteCp1252(var4);
               var2.append('%');
               int var6 = var5 >> 4 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }

               var6 = var5 & 15;
               if(var6 >= 10) {
                  var2.append((char)(var6 + 55));
               } else {
                  var2.append((char)(var6 + 48));
               }
            }
         } else {
            var2.append(var4);
         }
      }

      return var2.toString();
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ILhi;B)Lck;",
      garbageValue = "13"
   )
   static Script method83(int var0, class230 var1) {
      Script var2 = (Script)Script.field1431.get((long)(var0 << 16));
      if(var2 != null) {
         return var2;
      } else {
         String var3 = String.valueOf(var0);
         int var4 = class161.indexScripts.getFile(var3);
         if(var4 == -1) {
            return null;
         } else {
            byte[] var5 = class161.indexScripts.takeRecordFlat(var4);
            if(var5 != null) {
               if(var5.length <= 1) {
                  return null;
               }

               var2 = WidgetNode.newScript(var5);
               if(var2 != null) {
                  Script.field1431.put(var2, (long)(var0 << 16));
                  return var2;
               }
            }

            return null;
         }
      }
   }

   @ObfuscatedName("ha")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1420140280"
   )
   static void method82() {
      for(int var0 = 0; var0 < Client.menuOptionCount; ++var0) {
         int var2 = Client.menuTypes[var0];
         boolean var1 = var2 == 57 || var2 == 58 || var2 == 1007 || var2 == 25 || var2 == 30;
         if(var1) {
            if(var0 < Client.menuOptionCount - 1) {
               for(int var3 = var0; var3 < Client.menuOptionCount - 1; ++var3) {
                  Client.menuOptions[var3] = Client.menuOptions[var3 + 1];
                  Client.menuTargets[var3] = Client.menuTargets[var3 + 1];
                  Client.menuTypes[var3] = Client.menuTypes[var3 + 1];
                  Client.menuIdentifiers[var3] = Client.menuIdentifiers[var3 + 1];
                  Client.menuActionParams0[var3] = Client.menuActionParams0[var3 + 1];
                  Client.menuActionParams1[var3] = Client.menuActionParams1[var3 + 1];
                  Client.menuBooleanArray[var3] = Client.menuBooleanArray[var3 + 1];
               }
            }

            --Client.menuOptionCount;
         }
      }

   }
}
