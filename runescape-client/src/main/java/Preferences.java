import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ca")
@Implements("Preferences")
public class Preferences {
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -1137410471
   )
   static int field1297;
   @ObfuscatedName("e")
   boolean field1299;
   @ObfuscatedName("t")
   boolean field1300;
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = 1201869547
   )
   static int field1301;
   @ObfuscatedName("z")
   @Export("preferences")
   LinkedHashMap preferences;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -1722463755
   )
   int field1303;
   @ObfuscatedName("k")
   static String[] field1304;

   @ObfuscatedName("gi")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-24"
   )
   static void method1501() {
      if(Client.field1061) {
         Widget var0 = class172.method3015(class47.field611, Client.field1062);
         if(var0 != null && var0.field2746 != null) {
            class69 var1 = new class69();
            var1.field822 = var0;
            var1.field821 = var0.field2746;
            class77.method1440(var1);
         }

         Client.field1061 = false;
         XItemContainer.method1020(var0);
      }
   }

   Preferences() {
      this.field1303 = 1;
      this.preferences = new LinkedHashMap();
      this.method1502(true);
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-73"
   )
   void method1502(boolean var1) {
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)LBuffer;",
      garbageValue = "-1649572737"
   )
   Buffer method1503() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field1297);
      var1.putByte(this.field1299?1:0);
      var1.putByte(this.field1300?1:0);
      var1.putByte(this.field1303);
      var1.putByte(this.preferences.size());
      Iterator var2 = this.preferences.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.putInt(((Integer)var3.getKey()).intValue());
         var1.putInt(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }

   static {
      field1297 = 4;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1259561675"
   )
   public static void method1510() {
      KitDefinition.field3362.reset();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(II)LFloorUnderlayDefinition;",
      garbageValue = "2112026877"
   )
   public static FloorUnderlayDefinition method1512(int var0) {
      FloorUnderlayDefinition var1 = (FloorUnderlayDefinition)FloorUnderlayDefinition.field3349.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = class51.field669.getConfigData(1, var0);
         var1 = new FloorUnderlayDefinition();
         if(var2 != null) {
            var1.method4226(new Buffer(var2), var0);
         }

         var1.method4225();
         FloorUnderlayDefinition.field3349.put(var1, (long)var0);
         return var1;
      }
   }

   Preferences(Buffer var1) {
      this.field1303 = 1;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field1297) {
            if(var1.readUnsignedByte() == 1) {
               this.field1299 = true;
            }

            if(var2 > 1) {
               this.field1300 = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.field1303 = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.readInt();
                  int var6 = var1.readInt();
                  this.preferences.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method1502(true);
         }
      } else {
         this.method1502(true);
      }

   }
}
