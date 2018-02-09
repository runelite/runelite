import java.io.IOException;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fh")
@Implements("Timer")
public abstract class Timer {
   @ObfuscatedName("s")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1942817352"
   )
   public abstract void vmethod3287();

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(III)I",
      garbageValue = "2085537313"
   )
   public abstract int vmethod3288(int var1, int var2);

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(ZB)V",
      garbageValue = "-1"
   )
   @Export("sendConInfo")
   public static void sendConInfo(boolean var0) {
      if(class19.NetCache_socket != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class19.NetCache_socket.vmethod3304(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class19.NetCache_socket.vmethod3299();
            } catch (Exception var3) {
               ;
            }

            ++class249.field3355;
            class19.NetCache_socket = null;
         }

      }
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(Lgy;IB)Ljava/lang/String;",
      garbageValue = "-77"
   )
   static String method3296(Buffer var0, int var1) {
      try {
         int var2 = var0.getUSmart();
         if(var2 > var1) {
            var2 = var1;
         }

         byte[] var3 = new byte[var2];
         var0.offset += class288.huffman.decompress(var0.payload, var0.offset, var3, 0, var2);
         String var4 = ContextMenuRow.getString(var3, 0, var2);
         return var4;
      } catch (Exception var6) {
         return "Cabbage";
      }
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(ILcf;ZI)I",
      garbageValue = "-487357032"
   )
   static int method3294(int var0, Script var1, boolean var2) {
      int var3;
      int var4;
      int var6;
      if(var0 == 3400) {
         class80.intStackSize -= 2;
         var3 = class80.intStack[class80.intStackSize];
         var4 = class80.intStack[class80.intStackSize + 1];
         Enum var5 = class60.method983(var3);
         if(var5.valType != 's') {
            ;
         }

         for(var6 = 0; var6 < var5.size; ++var6) {
            if(var4 == var5.keys[var6]) {
               class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var5.stringVals[var6];
               var5 = null;
               break;
            }
         }

         if(var5 != null) {
            class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var5.defaultString;
         }

         return 1;
      } else if(var0 != 3408) {
         if(var0 == 3411) {
            var3 = class80.intStack[--class80.intStackSize];
            Enum var10 = class60.method983(var3);
            class80.intStack[++class80.intStackSize - 1] = var10.method4868();
            return 1;
         } else {
            return 2;
         }
      } else {
         class80.intStackSize -= 4;
         var3 = class80.intStack[class80.intStackSize];
         var4 = class80.intStack[class80.intStackSize + 1];
         int var9 = class80.intStack[class80.intStackSize + 2];
         var6 = class80.intStack[class80.intStackSize + 3];
         Enum var7 = class60.method983(var9);
         if(var3 == var7.keyType && var4 == var7.valType) {
            for(int var8 = 0; var8 < var7.size; ++var8) {
               if(var6 == var7.keys[var8]) {
                  if(var4 == 115) {
                     class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var7.stringVals[var8];
                  } else {
                     class80.intStack[++class80.intStackSize - 1] = var7.intVals[var8];
                  }

                  var7 = null;
                  break;
               }
            }

            if(var7 != null) {
               if(var4 == 115) {
                  class80.scriptStringStack[++class294.scriptStringStackSize - 1] = var7.defaultString;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = var7.defaultInt;
               }
            }

            return 1;
         } else {
            if(var4 == 115) {
               class80.scriptStringStack[++class294.scriptStringStackSize - 1] = "null";
            } else {
               class80.intStack[++class80.intStackSize - 1] = 0;
            }

            return 1;
         }
      }
   }
}
