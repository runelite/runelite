import net.runelite.mapping.Export;
import net.runelite.mapping.Implements;
import net.runelite.mapping.ObfuscatedGetter;
import net.runelite.mapping.ObfuscatedName;
import net.runelite.mapping.ObfuscatedSignature;

@ObfuscatedName("kv")
@Implements("ClanChat")
public class ClanChat extends UserList {
   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "Llx;"
   )
   @Export("loginType")
   final LoginType loginType;
   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "Lky;"
   )
   @Export("localUser")
   final Usernamed localUser;
   @ObfuscatedName("x")
   @Export("name")
   public String name;
   @ObfuscatedName("d")
   @Export("owner")
   public String owner;
   @ObfuscatedName("k")
   public byte field96;
   @ObfuscatedName("n")
   @ObfuscatedGetter(
      intValue = -1534670751
   )
   @Export("rank")
   public int rank;
   @ObfuscatedName("i")
   @ObfuscatedGetter(
      intValue = 386706253
   )
   int field97;

   @ObfuscatedSignature(
      signature = "(Llx;Lky;)V"
   )
   public ClanChat(LoginType var1, Usernamed var2) {
      super(100);
      this.name = null;
      this.owner = null;
      this.field97 = 1;
      this.loginType = var1;
      this.localUser = var2;
   }

   @ObfuscatedName("m")
   @ObfuscatedSignature(
      signature = "(I)Ljs;",
      garbageValue = "-2063112195"
   )
   @Export("newInstance")
   User newInstance() {
      return new ClanMate();
   }

   @ObfuscatedName("f")
   @ObfuscatedSignature(
      signature = "(II)[Ljs;",
      garbageValue = "861814350"
   )
   @Export("newTypedArray")
   User[] newTypedArray(int var1) {
      return new ClanMate[var1];
   }

   @ObfuscatedName("q")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;I)V",
      garbageValue = "242122326"
   )
   final void method76(String var1) {
      this.name = HealthBarUpdate.method1722(var1);
   }

   @ObfuscatedName("x")
   @ObfuscatedSignature(
      signature = "(Ljava/lang/String;B)V",
      garbageValue = "103"
   )
   final void method77(String var1) {
      this.owner = HealthBarUpdate.method1722(var1);
   }

   @ObfuscatedName("d")
   @ObfuscatedSignature(
      signature = "(Lgr;I)V",
      garbageValue = "455791964"
   )
   @Export("readUpdate")
   public final void readUpdate(Buffer var1) {
      this.method77(var1.readStringCp1252NullTerminated());
      long var2 = var1.readLong();
      long var4 = var2;
      String var6;
      int var7;
      if (var2 > 0L && var2 < 6582952005840035281L) {
         if (var2 % 37L == 0L) {
            var6 = null;
         } else {
            var7 = 0;

            for (long var8 = var2; var8 != 0L; var8 /= 37L) {
               ++var7;
            }

            StringBuilder var11 = new StringBuilder(var7);

            while (var4 != 0L) {
               long var9 = var4;
               var4 /= 37L;
               var11.append(class306.base37Table[(int)(var9 - 37L * var4)]);
            }

            var6 = var11.reverse().toString();
         }
      } else {
         var6 = null;
      }

      this.method76(var6);
      this.field96 = var1.readByte();
      var7 = var1.readUnsignedByte();
      if (var7 != 255) {
         this.clear();

         for (int var12 = 0; var12 < var7; ++var12) {
            ClanMate var13 = (ClanMate)this.addLastNoPreviousUsername(new Username(var1.readStringCp1252NullTerminated(), this.loginType));
            int var10 = var1.readUnsignedShort();
            var13.set(var10, ++this.field97 - 1);
            var13.rank = var1.readByte();
            var1.readStringCp1252NullTerminated();
            this.method79(var13);
         }
      }

   }

   @ObfuscatedName("a")
   @ObfuscatedSignature(
      signature = "(Lgr;B)V",
      garbageValue = "24"
   )
   public final void method78(Buffer var1) {
      Username var2 = new Username(var1.readStringCp1252NullTerminated(), this.loginType);
      int var3 = var1.readUnsignedShort();
      byte var4 = var1.readByte();
      boolean var5 = false;
      if (var4 == -128) {
         var5 = true;
      }

      ClanMate var6;
      if (var5) {
         if (this.size() == 0) {
            return;
         }

         var6 = (ClanMate)this.getByCurrentUsername(var2);
         if (var6 != null && var6.world() == var3) {
            this.remove(var6);
         }
      } else {
         var1.readStringCp1252NullTerminated();
         var6 = (ClanMate)this.getByCurrentUsername(var2);
         if (var6 == null) {
            if (this.size() > super.capacity) {
               return;
            }

            var6 = (ClanMate)this.addLastNoPreviousUsername(var2);
         }

         var6.set(var3, ++this.field97 - 1);
         var6.rank = var4;
         this.method79(var6);
      }

   }

   @ObfuscatedName("cg")
   @ObfuscatedSignature(
      signature = "(I)V",
      garbageValue = "1739085267"
   )
   @Export("clearFriends")
   public final void clearFriends() {
      for (int var1 = 0; var1 < this.size(); ++var1) {
         ((ClanMate)this.get(var1)).clearIsFriend();
      }

   }

   @ObfuscatedName("cf")
   @ObfuscatedSignature(
      signature = "(B)V",
      garbageValue = "-53"
   )
   @Export("clearIgnoreds")
   public final void clearIgnoreds() {
      for (int var1 = 0; var1 < this.size(); ++var1) {
         ((ClanMate)this.get(var1)).clearIsIgnored();
      }

   }

   @ObfuscatedName("cp")
   @ObfuscatedSignature(
      signature = "(Ljk;I)V",
      garbageValue = "-128608554"
   )
   final void method79(ClanMate var1) {
      if (var1.username().equals(this.localUser.username())) {
         this.rank = var1.rank;
      }

   }
}
