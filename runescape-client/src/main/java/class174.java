import java.util.zip.CRC32;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("fb")
public class class174 {
   @ObfuscatedName("u")
   public static boolean field2763;
   @ObfuscatedName("s")
   @ObfuscatedGetter(
      intValue = 541725869
   )
   public static int field2764 = 0;
   @ObfuscatedName("g")
   public static XHashTable field2765 = new XHashTable(32);
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = -568676177
   )
   public static int field2766 = 0;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      intValue = -432170897
   )
   public static int field2767 = 0;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      intValue = -26666679
   )
   public static int field2768 = 0;
   @ObfuscatedName("f")
   public static Node2LinkedList field2769 = new Node2LinkedList();
   @ObfuscatedName("k")
   public static XHashTable field2770 = new XHashTable(4096);
   @ObfuscatedName("r")
   public static XHashTable field2771 = new XHashTable(4096);
   @ObfuscatedName("z")
   public static class146 field2772;
   @ObfuscatedName("y")
   public static XHashTable field2773 = new XHashTable(4096);
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = 1493985305
   )
   public static int field2774 = 0;
   @ObfuscatedName("d")
   public static Buffer field2775 = new Buffer(8);
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -644622007
   )
   public static int field2776 = 0;
   @ObfuscatedName("o")
   public static CRC32 field2777 = new CRC32();
   @ObfuscatedName("i")
   public static class171[] field2778 = new class171[256];
   @ObfuscatedName("x")
   public static byte field2779 = 0;
   @ObfuscatedName("v")
   @ObfuscatedGetter(
      intValue = 1543335399
   )
   public static int field2780 = 0;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 1054745517
   )
   public static int field2781 = 0;

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(II)LItemComposition;",
      garbageValue = "-1556429044"
   )
   @Export("getItemDefinition")
   public static ItemComposition getItemDefinition(int var0) {
      ItemComposition var1 = (ItemComposition)ItemComposition.field1163.get((long)var0);
      if(var1 != null) {
         return var1;
      } else {
         byte[] var2 = ItemComposition.field1142.method3272(10, var0);
         var1 = new ItemComposition();
         var1.id = var0;
         if(null != var2) {
            var1.loadBuffer(new Buffer(var2));
         }

         var1.method1078();
         if(var1.field1181 != -1) {
            var1.method1131(getItemDefinition(var1.field1181), getItemDefinition(var1.note));
         }

         if(var1.field1190 != -1) {
            var1.method1082(getItemDefinition(var1.field1190), getItemDefinition(var1.field1189));
         }

         if(var1.field1154 != -1) {
            var1.method1083(getItemDefinition(var1.field1154), getItemDefinition(var1.field1191));
         }

         if(!class49.isMembersWorld && var1.isMembers) {
            var1.name = "Members object";
            var1.field1188 = false;
            var1.groundActions = null;
            var1.inventoryActions = null;
            var1.field1187 = 0;
         }

         ItemComposition.field1163.put(var1, (long)var0);
         return var1;
      }
   }

   @ObfuscatedName("t")
   @ObfuscatedSignature(
      signature = "(II)Z",
      garbageValue = "-1864381304"
   )
   public static boolean method3393(int var0) {
      if(Widget.validInterfaces[var0]) {
         return true;
      } else if(!Widget.field2788.method3253(var0)) {
         return false;
      } else {
         int var1 = Widget.field2788.method3260(var0);
         if(var1 == 0) {
            Widget.validInterfaces[var0] = true;
            return true;
         } else {
            if(null == Widget.widgets[var0]) {
               Widget.widgets[var0] = new Widget[var1];
            }

            for(int var2 = 0; var2 < var1; ++var2) {
               if(null == Widget.widgets[var0][var2]) {
                  byte[] var3 = Widget.field2788.method3272(var0, var2);
                  if(null != var3) {
                     Widget.widgets[var0][var2] = new Widget();
                     Widget.widgets[var0][var2].id = (var0 << 16) + var2;
                     if(var3[0] == -1) {
                        Widget.widgets[var0][var2].method3399(new Buffer(var3));
                     } else {
                        Widget.widgets[var0][var2].method3398(new Buffer(var3));
                     }
                  }
               }
            }

            Widget.validInterfaces[var0] = true;
            return true;
         }
      }
   }
}
