import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("em")
@Implements("FrameMap")
public class FrameMap extends Node {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      intValue = -1806685349
   )
   @Export("id")
   int id;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      intValue = 253180977
   )
   @Export("count")
   int count;
   @ObfuscatedName("i")
   @Export("types")
   int[] types;
   @ObfuscatedName("u")
   @Export("list")
   int[][] list;

   FrameMap(int var1, byte[] var2) {
      this.id = var1;
      Buffer var3 = new Buffer(var2);
      this.count = var3.readUnsignedByte();
      this.types = new int[this.count];
      this.list = new int[this.count][];

      int var4;
      for(var4 = 0; var4 < this.count; ++var4) {
         this.types[var4] = var3.readUnsignedByte();
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         this.list[var4] = new int[var3.readUnsignedByte()];
      }

      for(var4 = 0; var4 < this.count; ++var4) {
         for(int var5 = 0; var5 < this.list[var4].length; ++var5) {
            this.list[var4][var5] = var3.readUnsignedByte();
         }
      }

   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2040109837"
   )
   static void method2614() {
      if(Signlink.javaVendor.toLowerCase().indexOf("microsoft") != -1) {
         KeyFocusListener.field648[186] = 57;
         KeyFocusListener.field648[187] = 27;
         KeyFocusListener.field648[188] = 71;
         KeyFocusListener.field648[189] = 26;
         KeyFocusListener.field648[190] = 72;
         KeyFocusListener.field648[191] = 73;
         KeyFocusListener.field648[192] = 58;
         KeyFocusListener.field648[219] = 42;
         KeyFocusListener.field648[220] = 74;
         KeyFocusListener.field648[221] = 43;
         KeyFocusListener.field648[222] = 59;
         KeyFocusListener.field648[223] = 28;
      } else {
         KeyFocusListener.field648[44] = 71;
         KeyFocusListener.field648[45] = 26;
         KeyFocusListener.field648[46] = 72;
         KeyFocusListener.field648[47] = 73;
         KeyFocusListener.field648[59] = 57;
         KeyFocusListener.field648[61] = 27;
         KeyFocusListener.field648[91] = 42;
         KeyFocusListener.field648[92] = 74;
         KeyFocusListener.field648[93] = 43;
         KeyFocusListener.field648[192] = 28;
         KeyFocusListener.field648[222] = 58;
         KeyFocusListener.field648[520] = 59;
      }

   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-693525702"
   )
   public static void method2615() {
      FloorUnderlayDefinition.underlays.reset();
   }
}
