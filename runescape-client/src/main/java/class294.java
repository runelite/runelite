import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("ka")
public class class294 {
   @ObfuscatedName("c")
   @ObfuscatedGetter(
      longValue = 3871080943852353683L
   )
   long field3813;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      longValue = 2950692838860024433L
   )
   long field3814;
   @ObfuscatedName("o")
   public boolean field3816;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      longValue = -2844649675618233825L
   )
   long field3812;
   @ObfuscatedName("k")
   @ObfuscatedGetter(
      longValue = 8780928746491958551L
   )
   long field3809;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      longValue = -5068426977741909059L
   )
   long field3811;
   @ObfuscatedName("z")
   @ObfuscatedGetter(
      intValue = -1882026515
   )
   int field3815;
   @ObfuscatedName("p")
   @ObfuscatedGetter(
      intValue = 767031139
   )
   int field3810;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      intValue = -676871055
   )
   int field3817;
   @ObfuscatedName("r")
   @ObfuscatedGetter(
      intValue = -1083152399
   )
   int field3818;

   public class294() {
      this.field3813 = -1L;
      this.field3814 = -1L;
      this.field3816 = false;
      this.field3812 = 0L;
      this.field3809 = 0L;
      this.field3811 = 0L;
      this.field3815 = 0;
      this.field3810 = 0;
      this.field3817 = 0;
      this.field3818 = 0;
   }

   @ObfuscatedName("c")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-99"
   )
   public void method5210() {
      this.field3813 = ScriptVarType.method28();
   }

   @ObfuscatedName("i")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "698005078"
   )
   public void method5211() {
      if(this.field3813 != -1L) {
         this.field3809 = ScriptVarType.method28() - this.field3813;
         this.field3813 = -1L;
      }

   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "564059302"
   )
   public void method5212(int var1) {
      this.field3814 = ScriptVarType.method28();
      this.field3815 = var1;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-2041160622"
   )
   public void method5213() {
      if(this.field3814 != -1L) {
         this.field3812 = ScriptVarType.method28() - this.field3814;
         this.field3814 = -1L;
      }

      ++this.field3817;
      this.field3816 = true;
   }

   @ObfuscatedName("k")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "46"
   )
   public void method5214() {
      this.field3816 = false;
      this.field3810 = 0;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1349197388"
   )
   public void method5229() {
      this.method5213();
   }

   @ObfuscatedName("z")
   @ObfuscatedSignature(
      signature = "(Lgp;I)V",
      garbageValue = "138069334"
   )
   public void method5216(Buffer var1) {
      long var2 = this.field3809;
      var2 /= 10L;
      if(var2 < 0L) {
         var2 = 0L;
      } else if(var2 > 65535L) {
         var2 = 65535L;
      }

      var1.putShort((int)var2);
      long var4 = this.field3812;
      var4 /= 10L;
      if(var4 < 0L) {
         var4 = 0L;
      } else if(var4 > 65535L) {
         var4 = 65535L;
      }

      var1.putShort((int)var4);
      long var6 = this.field3811;
      var6 /= 10L;
      if(var6 < 0L) {
         var6 = 0L;
      } else if(var6 > 65535L) {
         var6 = 65535L;
      }

      var1.putShort((int)var6);
      var1.putShort(this.field3815);
      var1.putShort(this.field3810);
      var1.putShort(this.field3817);
      var1.putShort(this.field3818);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(CII)Ljava/lang/String;",
      garbageValue = "1405503077"
   )
   public static String method5232(char var0, int var1) {
      char[] var2 = new char[var1];

      for(int var3 = 0; var3 < var1; ++var3) {
         var2[var3] = var0;
      }

      return new String(var2);
   }
}
