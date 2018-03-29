import java.util.HashMap;
import java.util.Map;
import net.runelite.mapping.Export;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("cb")
public class class95 {
   @ObfuscatedName("c")
   @Export("chatLineMap")
   static final Map chatLineMap;
   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "Lhz;"
   )
   @Export("messages")
   static final IterableHashTable messages;
   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "Lhb;"
   )
   static final IterableDualNodeQueue field1434;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = 486804991
   )
   static int field1435;
   @ObfuscatedName("af")
   protected static String field1439;

   static {
      chatLineMap = new HashMap();
      messages = new IterableHashTable(1024);
      field1434 = new IterableDualNodeQueue();
      field1435 = 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(Ljm;IIIZB)V",
      garbageValue = "-8"
   )
   public static void method2007(IndexDataBase var0, int var1, int var2, int var3, boolean var4) {
      class229.field2680 = 1;
      class61.field714 = var0;
      class229.field2682 = var1;
      class152.field2129 = var2;
      Varcs.field1431 = var3;
      class313.field3910 = var4;
      BoundingBox3D.field249 = 10000;
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1248620206"
   )
   public static void method2008(int var0) {
      if(class229.field2680 != 0) {
         Varcs.field1431 = var0;
      } else {
         class229.field2679.method4144(var0);
      }

   }

   @ObfuscatedName("ge")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "184766083"
   )
   static void method2006(int var0, int var1) {
      if(Client.field1044 != 0 && var0 != -1) {
         method2007(class157.indexTrack2, var0, 0, Client.field1044, false);
         Client.field1090 = true;
      }

   }
}
