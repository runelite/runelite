import java.io.File;
import java.io.RandomAccessFile;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ao")
@Implements("Preferences")
public class Preferences {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = -1839616837
   )
   static int field689;
   @ObfuscatedName("n")
   boolean field690;
   @ObfuscatedName("q")
   boolean field691;
   @ObfuscatedName("t")
   @ObfuscatedGetter(
      intValue = 1023255843
   )
   int field692;
   @ObfuscatedName("p")
   @Export("preferences")
   LinkedHashMap preferences;

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;ZI)Z",
      garbageValue = "665353413"
   )
   public static boolean method642(File var0, boolean var1) {
      try {
         RandomAccessFile var2 = new RandomAccessFile(var0, "rw");
         int var3 = var2.read();
         var2.seek(0L);
         var2.write(var3);
         var2.seek(0L);
         var2.close();
         if(var1) {
            var0.delete();
         }

         return true;
      } catch (Exception var4) {
         return false;
      }
   }

   Preferences(Buffer var1) {
      this.field692 = 1;
      this.preferences = new LinkedHashMap();
      if(var1 != null && var1.payload != null) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field689) {
            if(var1.readUnsignedByte() == 1) {
               this.field690 = true;
            }

            if(var2 > 1) {
               this.field691 = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.field692 = var1.readUnsignedByte();
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
            this.method643(true);
         }
      } else {
         this.method643(true);
      }

   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "-1783066575"
   )
   void method643(boolean var1) {
   }

   Preferences() {
      this.field692 = 1;
      this.preferences = new LinkedHashMap();
      this.method643(true);
   }

   static {
      field689 = 4;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(ILScript;ZB)I",
      garbageValue = "-43"
   )
   static int method648(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      int var6;
      if(var0 == 3400) {
         class32.intStackSize -= 2;
         var3 = class32.intStack[class32.intStackSize];
         var4 = class32.intStack[class32.intStackSize + 1];
         class200 var5 = class105.method2038(var3);
         if(var5.field2886 != 115) {
            ;
         }

         for(var6 = 0; var6 < var5.field2885; ++var6) {
            if(var5.field2890[var6] == var4) {
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var5.field2889[var6];
               var5 = null;
               break;
            }
         }

         if(var5 != null) {
            class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var5.field2887;
         }

         return 1;
      } else if(var0 != 3408) {
         return 2;
      } else {
         class32.intStackSize -= 4;
         var3 = class32.intStack[class32.intStackSize];
         var4 = class32.intStack[class32.intStackSize + 1];
         int var9 = class32.intStack[class32.intStackSize + 2];
         var6 = class32.intStack[class32.intStackSize + 3];
         class200 var7 = class105.method2038(var9);
         if(var3 == var7.field2893 && var4 == var7.field2886) {
            for(int var8 = 0; var8 < var7.field2885; ++var8) {
               if(var6 == var7.field2890[var8]) {
                  if(var4 == 115) {
                     class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var7.field2889[var8];
                  } else {
                     class32.intStack[++class32.intStackSize - 1] = var7.field2891[var8];
                  }

                  var7 = null;
                  break;
               }
            }

            if(var7 != null) {
               if(var4 == 115) {
                  class32.scriptStringStack[++class32.scriptStringStackSize - 1] = var7.field2887;
               } else {
                  class32.intStack[++class32.intStackSize - 1] = var7.field2888;
               }
            }

            return 1;
         } else {
            if(var4 == 115) {
               class32.scriptStringStack[++class32.scriptStringStackSize - 1] = "null";
            } else {
               class32.intStack[++class32.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }

   @ObfuscatedName("br")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "-39314763"
   )
   static final void method649(int var0, int var1) {
      if(Client.field298 == 2) {
         CombatInfo1.method601(Client.field304 + (Client.field301 - class108.baseX << 7), Client.field305 + (Client.field302 - GameEngine.baseY << 7), Client.field303 * 2);
         if(Client.field388 > -1 && Client.gameCycle % 20 < 10) {
            class108.field1726[0].method4230(Client.field388 + var0 - 12, var1 + Client.field389 - 28);
         }

      }
   }

   @ObfuscatedName("p")
   @ObfuscatedSignature(
      signature = "(IB)Z",
      garbageValue = "1"
   )
   public static boolean method650(int var0) {
      return (var0 >> 31 & 1) != 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)LBuffer;",
      garbageValue = "32"
   )
   Buffer method651() {
      Buffer var1 = new Buffer(100);
      var1.putByte(field689);
      var1.putByte(this.field690?1:0);
      var1.putByte(this.field691?1:0);
      var1.putByte(this.field692);
      var1.putByte(this.preferences.size());
      Iterator var2 = this.preferences.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.putInt(((Integer)var3.getKey()).intValue());
         var1.putInt(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }
}
