import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cf")
@Implements("Preferences")
public class Preferences {
   @ObfuscatedName("v")
   boolean field1332;
   @ObfuscatedName("e")
   boolean field1333;
   @ObfuscatedName("gp")
   @ObfuscatedGetter(
      intValue = -597338299
   )
   @Export("cameraPitch")
   static int cameraPitch;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = 197732061
   )
   int field1336;
   @ObfuscatedName("y")
   @Export("preferences")
   LinkedHashMap preferences;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = -103065215
   )
   static int field1338;

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-87"
   )
   void method1584(boolean var1) {
   }

   Preferences(Buffer var1) {
      this.field1336 = 1;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field1338) {
            if(var1.readUnsignedByte() == 1) {
               this.field1333 = true;
            }

            if(var2 > 1) {
               this.field1332 = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.field1336 = var1.readUnsignedByte();
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
            this.method1584(true);
         }
      } else {
         this.method1584(true);
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)LBuffer;",
      garbageValue = "-41"
   )
   Buffer method1586() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field1338);
      var1.putByte(this.field1333?1:0);
      var1.putByte(this.field1332?1:0);
      var1.putByte(this.field1336);
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
      field1338 = 4;
   }

   Preferences() {
      this.field1336 = 1;
      this.preferences = new LinkedHashMap();
      this.method1584(true);
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1004200139"
   )
   public static void method1595(boolean var0) {
      if(class164.field2337 != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class164.field2337.queueForWrite(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class164.field2337.method2981();
            } catch (Exception var3) {
               ;
            }

            ++class238.field3263;
            class164.field2337 = null;
         }

      }
   }
}
