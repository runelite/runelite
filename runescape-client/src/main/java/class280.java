import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("jg")
public class class280 {
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -9012658550079385565L
   )
   long field3623;
   @ObfuscatedName("m")
   @ObfuscatedGetter(
      longValue = -3275646259930192925L
   )
   long field3614;
   @ObfuscatedName("q")
   public boolean field3616;
   @ObfuscatedName("b")
   @ObfuscatedGetter(
      longValue = 1197166858791094299L
   )
   long field3617;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = 1276025963897536649L
   )
   long field3618;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      longValue = -2983556943587383505L
   )
   long field3619;
   @ObfuscatedName("h")
   @ObfuscatedGetter(
      intValue = -859888475
   )
   int field3620;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 2108545345
   )
   int field3621;
   @ObfuscatedName("j")
   @ObfuscatedGetter(
      intValue = -1869587913
   )
   int field3622;
   @ObfuscatedName("a")
   @ObfuscatedGetter(
      intValue = 1646967081
   )
   int field3624;

   public class280() {
      this.field3623 = -1L;
      this.field3614 = -1L;
      this.field3616 = false;
      this.field3617 = 0L;
      this.field3618 = 0L;
      this.field3619 = 0L;
      this.field3620 = 0;
      this.field3621 = 0;
      this.field3622 = 0;
      this.field3624 = 0;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1514835331"
   )
   public void method5255() {
      this.field3623 = class166.method3456();
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-358043852"
   )
   public void method5256() {
      if(-1L != this.field3623) {
         this.field3618 = class166.method3456() - this.field3623;
         this.field3623 = -1L;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1214406130"
   )
   public void method5257(int var1) {
      this.field3614 = class166.method3456();
      this.field3620 = var1;
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1816217738"
   )
   public void method5259() {
      if(-1L != this.field3614) {
         this.field3617 = class166.method3456() - this.field3614;
         this.field3614 = -1L;
      }

      ++this.field3622;
      this.field3616 = true;
   }

   @ObfuscatedName("j")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1655481680"
   )
   public void method5254() {
      this.field3616 = false;
      this.field3621 = 0;
   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "0"
   )
   public void method5260() {
      this.method5259();
   }

   @ObfuscatedName("l")
   @ObfuscatedSignature(
      signature = "(Lgy;I)V",
      garbageValue = "-1002942983"
   )
   public void method5261(Buffer var1) {
      long var2 = this.field3618;
      var2 /= 10L;
      if(var2 < 0L) {
         var2 = 0L;
      } else if(var2 > 65535L) {
         var2 = 65535L;
      }

      var1.putShort((int)var2);
      long var4 = this.field3617;
      var4 /= 10L;
      if(var4 < 0L) {
         var4 = 0L;
      } else if(var4 > 65535L) {
         var4 = 65535L;
      }

      var1.putShort((int)var4);
      long var6 = this.field3619;
      var6 /= 10L;
      if(var6 < 0L) {
         var6 = 0L;
      } else if(var6 > 65535L) {
         var6 = 65535L;
      }

      var1.putShort((int)var6);
      var1.putShort(this.field3620);
      var1.putShort(this.field3621);
      var1.putShort(this.field3622);
      var1.putShort(this.field3624);
   }
}
