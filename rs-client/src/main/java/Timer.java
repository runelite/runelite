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
   @Export("__m")
   long __m;
   @ObfuscatedName("f")
   @ObfuscatedGetter(
      longValue = -8166664055136527097L
   )
   @Export("__f")
   long __f;
   @ObfuscatedName("q")
   @Export("__q")
   public boolean __q;
   @ObfuscatedName("w")
   @ObfuscatedGetter(
      longValue = -6206176920376957899L
   )
   @Export("__w")
   long __w;
   @ObfuscatedName("o")
   @ObfuscatedGetter(
      longValue = -5820022560321695785L
   )
   @Export("__o")
   long __o;
   @ObfuscatedName("u")
   @ObfuscatedGetter(
      longValue = -7044840680232740733L
   )
   @Export("__u")
   long __u;
   @ObfuscatedName("g")
   @ObfuscatedGetter(
      intValue = -500639955
   )
   @Export("__g")
   int __g;
   @ObfuscatedName("l")
   @ObfuscatedGetter(
      intValue = 2043109577
   )
   @Export("__l")
   int __l;
   @ObfuscatedName("e")
   @ObfuscatedGetter(
      intValue = 978183419
   )
   @Export("__e")
   int __e;
   @ObfuscatedName("x")
   @ObfuscatedGetter(
      intValue = 1684916659
   )
   @Export("__x")
   int __x;

   public Timer() {
      this.__m = -1L;
      this.__f = -1L;
      this.__q = false;
      this.__w = 0L;
      this.__o = 0L;
      this.__u = 0L;
      this.__g = 0;
      this.__l = 0;
      this.__e = 0;
      this.__x = 0;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "2027048361"
   )
   @Export("__m_453")
   public void __m_453() {
      this.__m = class203.currentTimeMs();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "3"
   )
   @Export("__f_454")
   public void __f_454() {
      if(-1L != this.__m) {
         this.__o = class203.currentTimeMs() - this.__m;
         this.__m = -1L;
      }

   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(II)V",
      garbageValue = "-1162738177"
   )
   @Export("__q_455")
   public void __q_455(int var1) {
      this.__f = class203.currentTimeMs();
      this.__g = var1;
   }

   @ObfuscatedName("w")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-1855026926"
   )
   @Export("__w_456")
   public void __w_456() {
      if(this.__f != -1L) {
         this.__w = class203.currentTimeMs() - this.__f;
         this.__f = -1L;
      }

      ++this.__e;
      this.__q = true;
   }

   @ObfuscatedName("o")
   @ObfuscatedSignature(
      signature = "(S)V",
      garbageValue = "-30171"
   )
   @Export("__o_457")
   public void __o_457() {
      this.__q = false;
      this.__l = 0;
   }

   @ObfuscatedName("u")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "-812012402"
   )
   @Export("__u_458")
   public void __u_458() {
      this.__w_456();
   }

   @ObfuscatedName("g")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "805398419"
   )
   @Export("write")
   public void write(Buffer var1) {
      long var2 = this.__o;
      var2 /= 10L;
      if(var2 < 0L) {
         var2 = 0L;
      } else if(var2 > 65535L) {
         var2 = 65535L;
      }

      var1.writeShort((int)var2);
      long var4 = this.__w;
      var4 /= 10L;
      if(var4 < 0L) {
         var4 = 0L;
      } else if(var4 > 65535L) {
         var4 = 65535L;
      }

      var1.writeShort((int)var4);
      long var6 = this.__u;
      var6 /= 10L;
      if(var6 < 0L) {
         var6 = 0L;
      } else if(var6 > 65535L) {
         var6 = 65535L;
      }

      var1.writeShort((int)var6);
      var1.writeShort(this.__g);
      var1.writeShort(this.__l);
      var1.writeShort(this.__e);
      var1.writeShort(this.__x);
   }
}
