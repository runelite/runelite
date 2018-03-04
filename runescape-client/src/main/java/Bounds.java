import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;
import net.runelite.rs.Reflection;

@ObfuscatedName("lj")
@Implements("Bounds")
public class Bounds {
   @ObfuscatedName("d")
   @ObfuscatedGetter(
      intValue = 1551717403
   )
   public int field3939;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = 1406927319
   )
   public int field3935;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1017079649
   )
   public int field3937;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -140278913
   )
   public int field3936;

   public Bounds(int var1, int var2, int var3, int var4) {
      this.method5760(var1, var2);
      this.method5756(var3, var4);
   }

   public Bounds(int var1, int var2) {
      this(0, 0, var1, var2);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "1397064166"
   )
   public void method5760(int var1, int var2) {
      this.field3939 = var1;
      this.field3935 = var2;
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(III)V",
      garbageValue = "752877777"
   )
   public void method5756(int var1, int var2) {
      this.field3937 = var1;
      this.field3936 = var2;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Llj;Llj;B)V",
      garbageValue = "28"
   )
   public void method5758(Bounds var1, Bounds var2) {
      this.method5759(var1, var2);
      this.method5765(var1, var2);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Llj;Llj;B)V",
      garbageValue = "59"
   )
   void method5759(Bounds var1, Bounds var2) {
      var2.field3939 = this.field3939;
      var2.field3937 = this.field3937;
      if(this.field3939 < var1.field3939) {
         var2.field3937 -= var1.field3939 - this.field3939;
         var2.field3939 = var1.field3939;
      }

      if(var2.method5761() > var1.method5761()) {
         var2.field3937 -= var2.method5761() - var1.method5761();
      }

      if(var2.field3937 < 0) {
         var2.field3937 = 0;
      }

   }

   @ObfuscatedName("e")
   @ObfuscatedSignature(
      signature = "(Llj;Llj;I)V",
      garbageValue = "-795570511"
   )
   void method5765(Bounds var1, Bounds var2) {
      var2.field3935 = this.field3935;
      var2.field3936 = this.field3936;
      if(this.field3935 < var1.field3935) {
         var2.field3936 -= var1.field3935 - this.field3935;
         var2.field3935 = var1.field3935;
      }

      if(var2.method5780() > var1.method5780()) {
         var2.field3936 -= var2.method5780() - var1.method5780();
      }

      if(var2.field3936 < 0) {
         var2.field3936 = 0;
      }

   }

   @ObfuscatedName("y")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1615108158"
   )
   int method5761() {
      return this.field3939 + this.field3937;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(I)I",
      garbageValue = "1112693754"
   )
   int method5780() {
      return this.field3935 + this.field3936;
   }

   public String toString() {
      return null;
   }

   @ObfuscatedName("n")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/CharSequence;IS)I",
      garbageValue = "-26562"
   )
   public static int method5781(CharSequence var0, int var1) {
      return class132.parseInt(var0, var1, true);
   }

   @ObfuscatedName("r")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)Ljava/lang/Class;",
      garbageValue = "-1345814210"
   )
   @Export("loadClassFromDescriptor")
   static Class loadClassFromDescriptor(String var0) throws ClassNotFoundException {
      return var0.equals("B")?Byte.TYPE:(var0.equals("I")?Integer.TYPE:(var0.equals("S")?Short.TYPE:(var0.equals("J")?Long.TYPE:(var0.equals("Z")?Boolean.TYPE:(var0.equals("F")?Float.TYPE:(var0.equals("D")?Double.TYPE:(var0.equals("C")?Character.TYPE:(var0.equals("void")?Void.TYPE:Reflection.findClass(var0)))))))));
   }
}
