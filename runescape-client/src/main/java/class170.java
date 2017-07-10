import java.io.IOException;
import java.util.concurrent.ScheduledExecutorService;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fg")
public class class170 {
   @ObfuscatedName("y")
   static ScheduledExecutorService field2356;

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(ZI)V",
      garbageValue = "1202154413"
   )
   public static void method3115(boolean var0) {
      if(class238.field3272 != null) {
         try {
            Buffer var1 = new Buffer(4);
            var1.putByte(var0?2:3);
            var1.put24bitInt(0);
            class238.field3272.queueForWrite(var1.payload, 0, 4);
         } catch (IOException var4) {
            try {
               class238.field3272.close();
            } catch (Exception var3) {
               ;
            }

            ++class238.field3278;
            class238.field3272 = null;
         }

      }
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(LIndexDataBase;LIndexDataBase;ZLFont;I)V",
      garbageValue = "-1488226804"
   )
   public static void method3116(IndexDataBase var0, IndexDataBase var1, boolean var2, Font var3) {
      class229.field3172 = var0;
      FileSystem.field3207 = var1;
      XItemContainer.isMembersWorld = var2;
      CombatInfoListHolder.field1389 = class229.field3172.method4133(10);
      class252.field3407 = var3;
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(ILScript;ZI)I",
      garbageValue = "1204189302"
   )
   static int method3117(int var0, Script var1, boolean var2) {
      int var3 = -1;
      Widget var4;
      if(var0 >= 2000) {
         var0 -= 1000;
         var3 = class83.intStack[--class46.intStackSize];
         var4 = PacketBuffer.method3403(var3);
      } else {
         var4 = var2?class83.field1364:class60.field766;
      }

      if(var0 == 1000) {
         class46.intStackSize -= 4;
         var4.originalX = class83.intStack[class46.intStackSize];
         var4.originalY = class83.intStack[class46.intStackSize + 1];
         var4.field2659 = class83.intStack[class46.intStackSize + 2];
         var4.field2660 = class83.intStack[class46.intStackSize + 3];
         class88.method1714(var4);
         class261.field3632.method1343(var4);
         if(var3 != -1 && var4.type == 0) {
            WorldMapType2.method546(class46.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1001) {
         class46.intStackSize -= 4;
         var4.originalWidth = class83.intStack[class46.intStackSize];
         var4.field2707 = class83.intStack[class46.intStackSize + 1];
         var4.field2683 = class83.intStack[class46.intStackSize + 2];
         var4.field2662 = class83.intStack[class46.intStackSize + 3];
         class88.method1714(var4);
         class261.field3632.method1343(var4);
         if(var3 != -1 && var4.type == 0) {
            WorldMapType2.method546(class46.widgets[var3 >> 16], var4, false);
         }

         return 1;
      } else if(var0 == 1003) {
         boolean var5 = class83.intStack[--class46.intStackSize] == 1;
         if(var5 != var4.isHidden) {
            var4.isHidden = var5;
            class88.method1714(var4);
         }

         return 1;
      } else if(var0 == 1005) {
         var4.field2685 = class83.intStack[--class46.intStackSize] == 1;
         return 1;
      } else if(var0 == 1006) {
         var4.field2783 = class83.intStack[--class46.intStackSize] == 1;
         return 1;
      } else {
         return 2;
      }
   }
}
