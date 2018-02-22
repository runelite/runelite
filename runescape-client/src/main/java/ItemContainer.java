import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.net.URL;
import java.net.URLConnection;
import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("bg")
@Implements("ItemContainer")
public class ItemContainer extends Node {
   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "Lhk;"
   )
   @Export("itemContainers")
   static HashTable itemContainers;
   @ObfuscatedName("ln")
   @ObfuscatedGetter(
      intValue = -1148490259
   )
   static int field721;
   @ObfuscatedName("q")
   @Export("itemIds")
   int[] itemIds;
   @ObfuscatedName("o")
   @Export("stackSizes")
   int[] stackSizes;

   static {
      itemContainers = new HashTable(32);
   }

   ItemContainer() {
      this.itemIds = new int[]{-1};
      this.stackSizes = new int[]{0};
   }

   @ObfuscatedName("b")
   @ObfuscatedSignature(
      signature = "(I)J",
      garbageValue = "-922147960"
   )
   static long method1112() {
      try {
         URL var0 = new URL(ScriptEvent.method1136("services", false) + "m=accountappeal/login.ws");
         URLConnection var1 = var0.openConnection();
         var1.setRequestProperty("connection", "close");
         var1.setDoInput(true);
         var1.setDoOutput(true);
         var1.setConnectTimeout(5000);
         OutputStreamWriter var2 = new OutputStreamWriter(var1.getOutputStream());
         var2.write("data1=req");
         var2.flush();
         InputStream var3 = var1.getInputStream();
         Buffer var4 = new Buffer(new byte[1000]);

         do {
            int var5 = var3.read(var4.payload, var4.offset, 1000 - var4.offset);
            if(var5 == -1) {
               var4.offset = 0;
               long var7 = var4.readLong();
               return var7;
            }

            var4.offset += var5;
         } while(var4.offset < 1000);

         return 0L;
      } catch (Exception var9) {
         return 0L;
      }
   }

   @ObfuscatedName("am")
   @ObfuscatedSignature(
      signature = "(ILca;ZI)I",
      garbageValue = "552816695"
   )
   static int method1122(int var0, Script var1, boolean var2) {
      int var3;
      if(var0 == 4200) {
         var3 = class80.intStack[--class80.intStackSize];
         class80.scriptStringStack[++class43.scriptStringStackSize - 1] = ContextMenuRow.getItemDefinition(var3).name;
         return 1;
      } else {
         int var4;
         ItemComposition var5;
         if(var0 == 4201) {
            class80.intStackSize -= 2;
            var3 = class80.intStack[class80.intStackSize];
            var4 = class80.intStack[class80.intStackSize + 1];
            var5 = ContextMenuRow.getItemDefinition(var3);
            if(var4 >= 1 && var4 <= 5 && var5.groundActions[var4 - 1] != null) {
               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var5.groundActions[var4 - 1];
            } else {
               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4202) {
            class80.intStackSize -= 2;
            var3 = class80.intStack[class80.intStackSize];
            var4 = class80.intStack[class80.intStackSize + 1];
            var5 = ContextMenuRow.getItemDefinition(var3);
            if(var4 >= 1 && var4 <= 5 && var5.inventoryActions[var4 - 1] != null) {
               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = var5.inventoryActions[var4 - 1];
            } else {
               class80.scriptStringStack[++class43.scriptStringStackSize - 1] = "";
            }

            return 1;
         } else if(var0 == 4203) {
            var3 = class80.intStack[--class80.intStackSize];
            class80.intStack[++class80.intStackSize - 1] = ContextMenuRow.getItemDefinition(var3).price;
            return 1;
         } else if(var0 == 4204) {
            var3 = class80.intStack[--class80.intStackSize];
            class80.intStack[++class80.intStackSize - 1] = ContextMenuRow.getItemDefinition(var3).isStackable == 1?1:0;
            return 1;
         } else {
            ItemComposition var6;
            if(var0 == 4205) {
               var3 = class80.intStack[--class80.intStackSize];
               var6 = ContextMenuRow.getItemDefinition(var3);
               if(var6.notedTemplate == -1 && var6.note >= 0) {
                  class80.intStack[++class80.intStackSize - 1] = var6.note;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4206) {
               var3 = class80.intStack[--class80.intStackSize];
               var6 = ContextMenuRow.getItemDefinition(var3);
               if(var6.notedTemplate >= 0 && var6.note >= 0) {
                  class80.intStack[++class80.intStackSize - 1] = var6.note;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4207) {
               var3 = class80.intStack[--class80.intStackSize];
               class80.intStack[++class80.intStackSize - 1] = ContextMenuRow.getItemDefinition(var3).isMembers?1:0;
               return 1;
            } else if(var0 == 4208) {
               var3 = class80.intStack[--class80.intStackSize];
               var6 = ContextMenuRow.getItemDefinition(var3);
               if(var6.int3 == -1 && var6.int2 >= 0) {
                  class80.intStack[++class80.intStackSize - 1] = var6.int2;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4209) {
               var3 = class80.intStack[--class80.intStackSize];
               var6 = ContextMenuRow.getItemDefinition(var3);
               if(var6.int3 >= 0 && var6.int2 >= 0) {
                  class80.intStack[++class80.intStackSize - 1] = var6.int2;
               } else {
                  class80.intStack[++class80.intStackSize - 1] = var3;
               }

               return 1;
            } else if(var0 == 4210) {
               String var7 = class80.scriptStringStack[--class43.scriptStringStackSize];
               var4 = class80.intStack[--class80.intStackSize];
               ScriptState.method1102(var7, var4 == 1);
               class80.intStack[++class80.intStackSize - 1] = Item.field1367;
               return 1;
            } else if(var0 != 4211) {
               if(var0 == 4212) {
                  GrandExchangeEvents.field268 = 0;
                  return 1;
               } else {
                  return 2;
               }
            } else {
               if(NetWriter.field1432 != null && GrandExchangeEvents.field268 < Item.field1367) {
                  class80.intStack[++class80.intStackSize - 1] = NetWriter.field1432[++GrandExchangeEvents.field268 - 1] & '\uffff';
               } else {
                  class80.intStack[++class80.intStackSize - 1] = -1;
               }

               return 1;
            }
         }
      }
   }
}
