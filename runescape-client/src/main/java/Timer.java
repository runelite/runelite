import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jo")
@Implements("Timer")
public class Timer {
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = 6181704275746246665L
   )
   long field919;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -8166664055136527097L
   )
   long field920;
   @ObfuscatedName("q")
   public boolean field921;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -6206176920376957899L
   )
   long field922;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = -5820022560321695785L
   )
   long field923;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = -7044840680232740733L
   )
   long field924;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -500639955
   )
   int field925;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2043109577
   )
   int field926;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 978183419
   )
   int field927;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1684916659
   )
   int field928;

   public Timer() {
      this.field919 = -1L;
      this.field920 = -1L;
      this.field921 = false;
      this.field922 = 0L;
      this.field923 = 0L;
      this.field924 = 0L;
      this.field925 = 0;
      this.field926 = 0;
      this.field927 = 0;
      this.field928 = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2027048361"
   )
   public void method329() {
      this.field919 = class203.currentTimeMs();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "3"
   )
   public void method330() {
      if (-1L != this.field919) {
         this.field923 = class203.currentTimeMs() - this.field919;
         this.field919 = -1L;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1162738177"
   )
   public void method331(int var1) {
      this.field920 = class203.currentTimeMs();
      this.field925 = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1855026926"
   )
   public void method332() {
      if (this.field920 != -1L) {
         this.field922 = class203.currentTimeMs() - this.field920;
         this.field920 = -1L;
      }

      ++this.field927;
      this.field921 = true;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-30171"
   )
   public void method333() {
      this.field921 = false;
      this.field926 = 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-812012402"
   )
   public void method334() {
      this.method332();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "805398419"
   )
   @Export("write")
   public void write(Buffer var1) {
      long var2 = this.field923;
      var2 /= 10L;
      if (var2 < 0L) {
         var2 = 0L;
      } else if (var2 > 65535L) {
         var2 = 65535L;
      }

      var1.writeShort((int)var2);
      long var4 = this.field922;
      var4 /= 10L;
      if (var4 < 0L) {
         var4 = 0L;
      } else if (var4 > 65535L) {
         var4 = 65535L;
      }

      var1.writeShort((int)var4);
      long var6 = this.field924;
      var6 /= 10L;
      if (var6 < 0L) {
         var6 = 0L;
      } else if (var6 > 65535L) {
         var6 = 65535L;
      }

      var1.writeShort((int)var6);
      var1.writeShort(this.field925);
      var1.writeShort(this.field926);
      var1.writeShort(this.field927);
      var1.writeShort(this.field928);
   }
}
