import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map.Entry;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ae")
public class class30 {
   @ObfuscatedName("ac")
   static int[] field688;
   @ObfuscatedName("g")
   boolean field690;
   @ObfuscatedName("v")
   boolean field691;
   @ObfuscatedName("p")
   LinkedHashMap field692 = new LinkedHashMap();
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 43368869
   )
   static int field693 = 4;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 1774854491
   )
   @Export("scriptStringStackSize")
   static int scriptStringStackSize;
   @ObfuscatedName("y")
   @ObfuscatedGetter(
      intValue = 741632181
   )
   int field697 = 1;
   @ObfuscatedName("f")
   static class60 field698;

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(IB)LScript;",
      garbageValue = "18"
   )
   static Script method695(int var0) {
      Script var1 = (Script)Script.field951.get((long)var0);
      if(null != var1) {
         return var1;
      } else {
         byte[] var2 = Tile.field1358.getConfigData(var0, 0);
         if(var2 == null) {
            return null;
         } else {
            var1 = new Script();
            Buffer var3 = new Buffer(var2);
            var3.offset = var3.payload.length - 12;
            int var4 = var3.readInt();
            var1.localIntCount = var3.readUnsignedShort();
            var1.localStringCount = var3.readUnsignedShort();
            var1.intStackCount = var3.readUnsignedShort();
            var1.stringStackCount = var3.readUnsignedShort();
            var3.offset = 0;
            var3.method2893();
            var1.instructions = new int[var4];
            var1.intOperands = new int[var4];
            var1.stringOperands = new String[var4];

            int var6;
            for(int var5 = 0; var3.offset < var3.payload.length - 12; var1.instructions[var5++] = var6) {
               var6 = var3.readUnsignedShort();
               if(var6 == 3) {
                  var1.stringOperands[var5] = var3.readString();
               } else if(var6 < 100 && var6 != 21 && var6 != 38 && var6 != 39) {
                  var1.intOperands[var5] = var3.readInt();
               } else {
                  var1.intOperands[var5] = var3.readUnsignedByte();
               }
            }

            Script.field951.put(var1, (long)var0);
            return var1;
         }
      }
   }

   class30(Buffer var1) {
      if(var1 != null && null != var1.payload) {
         int var2 = var1.readUnsignedByte();
         if(var2 >= 0 && var2 <= field693) {
            if(var1.readUnsignedByte() == 1) {
               this.field690 = true;
            }

            if(var2 > 1) {
               this.field691 = var1.readUnsignedByte() == 1;
            }

            if(var2 > 3) {
               this.field697 = var1.readUnsignedByte();
            }

            if(var2 > 2) {
               int var3 = var1.readUnsignedByte();

               for(int var4 = 0; var4 < var3; ++var4) {
                  int var5 = var1.readInt();
                  int var6 = var1.readInt();
                  this.field692.put(Integer.valueOf(var5), Integer.valueOf(var6));
               }
            }
         } else {
            this.method696(true);
         }
      } else {
         this.method696(true);
      }

   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "54"
   )
   void method696(boolean var1) {
   }

   class30() {
      this.method696(true);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(II)LVarbit;",
      garbageValue = "-1593352596"
   )
   public static Varbit method704(int var0) {
      Varbit var1 = (Varbit)Varbit.field2857.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = Varbit.field2854.getConfigData(14, var0);
         var1 = new Varbit();
         if(var2 != null) {
            var1.method3610(new Buffer(var2));
         }

         Varbit.field2857.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/io/File;Ljava/io/File;I)V",
      garbageValue = "2145646535"
   )
   static void method705(File var0, File var1) {
      try {
         FileOnDisk var2 = new FileOnDisk(class104.field1692, "rw", 10000L);
         Buffer var3 = new Buffer(500);
         var3.method2873(3);
         var3.method2873(var1 != null?1:0);
         var3.method2879(var0.getPath());
         if(null != var1) {
            var3.method2879("");
         }

         var2.method1495(var3.payload, 0, var3.offset);
         var2.method1488();
      } catch (IOException var4) {
         var4.printStackTrace();
      }

   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(I)LBuffer;",
      garbageValue = "1418267298"
   )
   Buffer method706() {
      Buffer var1 = new Buffer(100);
      var1.method2873(field693);
      var1.method2873(this.field690?1:0);
      var1.method2873(this.field691?1:0);
      var1.method2873(this.field697);
      var1.method2873(this.field692.size());
      Iterator var2 = this.field692.entrySet().iterator();

      while(var2.hasNext()) {
         Entry var3 = (Entry)var2.next();
         var1.method2874(((Integer)var3.getKey()).intValue());
         var1.method2874(((Integer)var3.getValue()).intValue());
      }

      return var1;
   }
}
